package br.edu.ifg;

import java.util.ArrayList;

public class Usuario {
	private String nomeCompleto;
	private String nomeUsuario;
	private String senha;
	private int id;

	public Usuario(String nomeCompleto, String nomeUsuario, String senha, int id) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.id = id;

	}

	public Usuario() {

	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
