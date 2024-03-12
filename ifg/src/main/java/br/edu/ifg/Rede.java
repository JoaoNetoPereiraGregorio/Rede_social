package br.edu.ifg;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel;

import ifg.Programa;

public class Rede implements InterfaceRede {
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	Map<Integer, ArrayList<Amizade>> amigosMap = new HashMap<Integer, ArrayList<Amizade>>();
	Map<Integer, ArrayList<Postagem>> postagemMap = new HashMap<Integer, ArrayList<Postagem>>();

	public static void preencheUsuarios(ArrayList<Usuario> usuarios) throws SQLException {
		java.sql.ResultSet rs = Programa.select("select *  from usuario;");
		while (rs.next()) {

			Usuario usuario = new Usuario(rs.getString("nome_completo"), rs.getString("nome_usuario"),
					rs.getString("senha"), rs.getInt("id_usuario"));
			usuarios.add(usuario);
		}
	}

	public static void preenchePostagemMap(Map<Integer, ArrayList<Postagem>> postagemMap) throws SQLException {
		java.sql.ResultSet rs = Programa.select("select *  from postagem;");
		while (rs.next()) {
			Postagem postagem = new Postagem(rs.getInt("id_usuario"), rs.getString("conteudo"),
					rs.getInt("id_postagem"));
			postagemMap.computeIfAbsent(rs.getInt("id_usuario"), k -> new ArrayList<>()).add(postagem);

		}
	}

	public static void preencheAmigosMap(Map<Integer, ArrayList<Amizade>> amizadeMap, ArrayList<Usuario> usuarios)
			throws SQLException {
		java.sql.ResultSet rs = Programa.select("select *  from amizade;");
		Usuario usuarioPrincipal = null;
		Usuario usuarioAmigo = null;
		while (rs.next()) {
			for (Usuario usuario : usuarios) {
				if (usuario.getId() == rs.getInt("id_usuario")) {
					usuarioPrincipal = usuario;
				}

				if (usuario.getId() == rs.getInt("id_usuario_amigo")) {
					usuarioAmigo = usuario;

				}
			}
			Amizade amizade = new Amizade(usuarioPrincipal, usuarioAmigo, rs.getInt("id_amizade"));
			amizadeMap.computeIfAbsent(rs.getInt("id_usuario"), k -> new ArrayList<>()).add(amizade);
		}
	}

	public static boolean cadastraUsuario(ArrayList<Usuario> usuarios, String nomeCompleto, String nomeUsuario,
			String senha) throws SQLException {

		try {
			Programa.insert(
					" insert into usuario values (null,'" + nomeCompleto + "','" + nomeUsuario + "','" + senha + "');");

			java.sql.ResultSet rs = Programa
					.select("select id_usuario from usuario where nome_usuario='" + nomeUsuario + "';");

			while (rs.next()) {
				Usuario usuario = new Usuario(nomeCompleto, nomeUsuario, senha, rs.getInt("id_usuario"));
				usuarios.add(usuario);

			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static Usuario realizaLogin(ArrayList<Usuario> usuarios, String nomeUsuario, String Senha) {
		Usuario usuario = null;
		for (Usuario umUsuario : usuarios) {
			if (umUsuario.getNomeUsuario().equals(nomeUsuario) && umUsuario.getSenha().equals(Senha)) {
				usuario = umUsuario;

			}
		}
		return usuario;
	}

	public static void adicionaPostagem(Map<Integer, ArrayList<Postagem>> postagemMap, int idUsuario, String conteudo)
			throws SQLException {
		try {
			Programa.insert("insert into postagem values (null,'" + conteudo + "','" + idUsuario + "');");

			java.sql.ResultSet rs = Programa
					.select("select id_postagem from postagem order by id_postagem desc limit 1;");

			while (rs.next()) {
				Postagem postagem = new Postagem(idUsuario, conteudo, rs.getInt("id_postagem"));
				postagemMap.computeIfAbsent(idUsuario, k -> new ArrayList<>()).add(postagem);
			}

		} catch (Exception e) {

			// TODO: handle exception
		}
	}

	public static void removerPostagem(Map<Integer, ArrayList<Postagem>> postagemMap, int idPostagem, int idUsuario)
			throws SQLException {

		Programa.delete("delete from postagem where id_postagem=" + idPostagem + ";");
		postagemMap.clear();
		preenchePostagemMap(postagemMap);
	}

	public static void addAmizade(ArrayList<Usuario> usuarios, Map<Integer, ArrayList<Amizade>> amizadeMap,
			int idUsuarioPrincipal, int idUsuarioAmigo) throws SQLException {
		Usuario usuarioPrincipal = null;
		Usuario usuarioAmigo = null;
		Programa.insert("insert into amizade values (null," + idUsuarioPrincipal + "," + idUsuarioAmigo + ");");
		Programa.insert("insert into amizade values (null," + idUsuarioAmigo + "," + idUsuarioPrincipal + ");");
		amizadeMap.clear();
		preencheAmigosMap(amizadeMap, usuarios);
	}

	public static void removerAmizade(ArrayList<Usuario> usuarios, Map<Integer, ArrayList<Amizade>> amizadeMap,
			int idAmizade) throws SQLException {
		Programa.delete("delete from amizade where id_amizade=" + idAmizade + ";");
		amizadeMap.clear();
		preencheAmigosMap(amizadeMap, usuarios);
	}

	public static ArrayList<Amizade> visualizarAmigos(Map<Integer, ArrayList<Amizade>> amigosMap, int idUsuario) {
		ArrayList<Amizade> amigos = amigosMap.get(idUsuario);

		return amigos;
	}

	public static ArrayList<Usuario> sugestoesAmizade(ArrayList<Usuario> usuarios,
			Map<Integer, ArrayList<Amizade>> amigosMap, int idUsuario) throws SQLException {

		ArrayList<Amizade> amigos = amigosMap.get(idUsuario);
		ArrayList<Usuario> usuariosNaoAmigos = new ArrayList<>();
		if (amigos == null) {
			for (Usuario usuario : usuarios) {
				if (usuario.getId() != idUsuario) {
					usuariosNaoAmigos.add(usuario);
				}
			}
		} else {
			java.sql.ResultSet rs = Programa.select(
					"select u.id_usuario, u.nome_completo from usuario u where u.id_usuario not in (select id_usuario_amigo from amizade where id_usuario="
							+ idUsuario + ") and u.id_usuario <>" + idUsuario + ";");

			while (rs.next()) {
				for (Usuario usuario : usuarios) {
					if (rs.getInt("id_usuario") == usuario.getId()) {
						usuariosNaoAmigos.add(usuario);
					}
				}

			}
		}
		return usuariosNaoAmigos;
	}

	public static Usuario pesquisarUsuario(ArrayList<Usuario> usuarios, String nomeUsuario) {
		Usuario usuario = null;
		for (Usuario umUsuario : usuarios) {
			if (umUsuario.getNomeUsuario().equals(nomeUsuario)) {
				usuario = umUsuario;
			} else {
				usuario = null;
			}
		}
		return usuario;
	}

	public static ArrayList<Postagem> visualizarPostagens(Map<Integer, ArrayList<Postagem>> postagemMap,
			int idUsuario) {
		ArrayList<Postagem> postagem = postagemMap.get(idUsuario);

		return postagem;
	}

	public static ArrayList<String> feed(Usuario usuarioLogado,Map<Integer, ArrayList<Postagem>> postagemMap, ArrayList<Usuario> usuarios) {
		ArrayList<String> feed = new ArrayList<String>();
		String escrita = "";
		for (Usuario usuario : usuarios) {
			if(usuarioLogado.getId()!= usuario.getId()) {
			ArrayList<Postagem> postagem = postagemMap.get(usuario.getId());
			if (postagem == null) {

			} else {

				for (Postagem umaPostagem : postagem) {
					escrita += "\n\n\n\n" + usuario.getNomeUsuario() + "\n\n";
					escrita += umaPostagem.getConteudo() + "\n\n";
					feed.add(escrita);
					escrita = "";
				}

			}
		}
		}
		return feed;
	}
}
