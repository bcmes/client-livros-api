package bms.livros.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bms.livros.client.domain.Livro;

public class LivrosClient {
	
	private RestTemplate restTemplate;
	
	private String URI_BASE;
	private String URN_BASE = "/livros";
	private String credencialBase64;
	
	public LivrosClient(String url, String user, String pass) {
		
		restTemplate = new RestTemplate();
		URI_BASE = url+URN_BASE;
		String userAndPass = user+":"+pass;
		credencialBase64 = "Basic " + Base64.getEncoder().encodeToString(userAndPass.getBytes());
	}

	public List<Livro> listar() {

		RequestEntity<Void> requestEntity = RequestEntity
				.get(URI.create(URI_BASE))
				.header("Authorization", credencialBase64)
				.build();

		ResponseEntity<Livro[]> responseEntity = restTemplate.exchange(requestEntity, Livro[].class);

		return Arrays.asList(responseEntity.getBody());
	}

	public String salvar(Livro livro) {

		RequestEntity<Livro> requestEntity = RequestEntity
				.post(URI.create(URI_BASE))
				.header("Authorization", credencialBase64)
				.body(livro);

		ResponseEntity<Void> responseEntity = restTemplate.exchange(requestEntity, Void.class);

		return responseEntity.getHeaders().getLocation().toString();
	}
	
	public Livro buscar(String uri) {

		RequestEntity<Void> requestEntity = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencialBase64)
				.build();

		ResponseEntity<Livro> responseEntity = restTemplate.exchange(requestEntity, Livro.class);

		return responseEntity.getBody();
	}
}
