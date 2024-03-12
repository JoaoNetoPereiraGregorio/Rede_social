package br.edu.ifg;

public class Postagem {
	private int idUsuario;
	private String conteudo;
	private int id;

	

	public Postagem(int idUsuario, String conteudo, int id) {
		super();
		this.idUsuario=idUsuario;
		this.conteudo = conteudo;
		this.id = id;
	}

	public Postagem() {

	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
