package br.edu.ifg;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface InterfaceRede {

	public static void preencheUsuarios(ArrayList<Usuario> usuarios) throws SQLException {
	}

	public static void preenchePostagemMap(Map<Integer, ArrayList<Postagem>> postagemMap) throws SQLException {
	}

	public static void preencheAmigosMap(Map<Integer, ArrayList<Amizade>> amizadeMap, ArrayList<Usuario> usuarios)
			throws SQLException {
	}

	public static boolean cadastraUsuario(ArrayList<Usuario> usuarios, String nomeCompleto, String nomeUsuario,
			String senha) throws SQLException {
		return false;
	}

	public static Usuario realizaLogin(ArrayList<Usuario> usuarios, String nomeUsuario, String Senha) {
		return null;
	}

	public static void adicionaPostagem(Map<Integer, ArrayList<Postagem>> postagemMap, int idUsuario, String conteudo)
			throws SQLException {
	}

	public static void removerPostagem(Map<Integer, ArrayList<Postagem>> postagemMap, int idPostagem, int idUsuario)
			throws SQLException {
	}

	public static void addAmizade(ArrayList<Usuario> usuarios, Map<Integer, ArrayList<Amizade>> amizadeMap,
			int idUsuarioPrincipal, int idUsuarioAmigo) throws SQLException {
	}

	public static void removerAmizade(ArrayList<Usuario> usuarios, Map<Integer, ArrayList<Amizade>> amizadeMap,
			int idAmizade) throws SQLException {
	}

	public static ArrayList<Amizade> visualizarAmigos(Map<Integer, ArrayList<Amizade>> amigosMap, int idUsuario) {
		return null;
	}

	public static ArrayList<Usuario> sugestoesAmizade(ArrayList<Usuario> usuarios,
			Map<Integer, ArrayList<Amizade>> amigosMap, int idUsuario) throws SQLException {
		return null;
	}
	public static Usuario pesquisarUsuario(ArrayList<Usuario> usuarios, String nomeUsuario) {
		return null;
	}
	public static ArrayList<Postagem> visualizarPostagens(Map<Integer, ArrayList<Postagem>> postagemMap, int idUsuario) {
		return null;
	}
	
	public static ArrayList<String> feed(Usuario usuarioLogado,Map<Integer, ArrayList<Postagem>> postagemMap, ArrayList<Usuario> usuarios) {
		return null;
	}
}
