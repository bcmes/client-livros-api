package bms.livros.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import bms.livros.client.LivrosClient;
import bms.livros.client.domain.Livro;

public class App {
	public static void main(String[] args) throws ParseException {
		
		LivrosClient livrosClient = new LivrosClient("http://localhost:8080","mestre","123456");
		
		//Listar livros
		List<Livro> listarLivros = livrosClient.listar();
		for (Livro livro : listarLivros) {
			System.out.println("Livro : " + livro.getNome());
		}
		
		
		//Inserir Livro
		Livro livro = new Livro();
		livro.setNome("Livro 1");
		livro.setEditora("BSSolutions");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		livro.setDataPublicacao(simpleDateFormat.parse("01/01/2020"));
		livro.setPrefacio("Livro bom pra porra !");
		
		String location = livrosClient.salvar(livro);
		System.out.println("URI do livro criado: " + location);
		
		//Buscar um livro
		Livro livroBuscado = livrosClient.buscar(location);
		System.out.println(livroBuscado.getNome());
		
	}
}
