package bms.livros.client.domain;

import java.util.Date;

public class Comentario {

	private Long id;
	private String comentario;
	private String usuario;
	private Date dataComentario;
	private Livro livro;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getDataComentario() {
		return dataComentario;
	}
	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}
