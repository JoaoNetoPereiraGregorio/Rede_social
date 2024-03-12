package br.edu.ifg;

public class Amizade {
	private Usuario usuarioPrincipal;
	private Usuario usuarioAmigo;
	private int idAmizade;

	public Amizade(Usuario usuarioPrincipal, Usuario usuarioAmigo, int idAmizade) {
		super();
		this.usuarioPrincipal = usuarioPrincipal;
		this.usuarioAmigo = usuarioAmigo;
		this.idAmizade = idAmizade;
	}

	public Amizade() {
		
	}

	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}

	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}

	public Usuario getUsuarioAmigo() {
		return usuarioAmigo;
	}

	public void setUsuarioAmigo(Usuario usuarioAmigo) {
		this.usuarioAmigo = usuarioAmigo;
	}

	public int getIdAmizade() {
		return idAmizade;
	}

	public void setIdAmizade(int idAmizade) {
		this.idAmizade = idAmizade;
	}
	
	
}
