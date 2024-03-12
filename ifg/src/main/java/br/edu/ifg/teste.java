package br.edu.ifg;

import java.sql.SQLException;
import java.util.Collections;
import br.edu.ifg.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ifg.*;

public class teste {

	public static void main(String[] args) throws SQLException {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Map<Integer, ArrayList<Amizade>> amigosMap = new HashMap<Integer, ArrayList<Amizade>>();
		Map<Integer, ArrayList<Postagem>> postagemMap = new HashMap<Integer, ArrayList<Postagem>>();

//		java.sql.ResultSet rs = Programa.select("select *  from usuario;");
//		while (rs.next()) {
//			
//			Usuario usuario= new Usuario(rs.getString("nome_completo"), rs.getString("nome_usuario"), rs.getString("senha"), rs.getInt("id_usuario"));
//			usuarios.add(usuario);
//	}

		Rede.preencheUsuarios(usuarios);
		Rede.preenchePostagemMap(postagemMap);
		Rede.preencheAmigosMap(amigosMap, usuarios);
	
	
	
		// Rede.cadastraUsuario(usuarios,"Leandro Vinicios", "Vini", "5555");
		// int id=Rede.login(usuarios, "MCc", "22222");
		//Rede.adicionaPostagem(postagemMap, 1, "Testando somente novamente 1!");
		//Rede.removerPostagem(postagemMap, 16, 3);
		//Rede.addAmizade(usuarios, amigosMap, 1, 4 );
		//Rede.removerAmizade(usuarios, amigosMap, 7);
		//Rede.visualizarAmigos(amigosMap, 1);
	//	Rede.sugestoesAmizade(usuarios, amigosMap, 4);
		//Usuario usuario= Rede.pesquisarUsuarioAmigo(usuarios, "jnpg");
		//System.out.println(usuario.getNomeCompleto());

//		for (Usuario umUsuario : usuarios) {
//			System.out.print(umUsuario.getId() + umUsuario.getNomeCompleto() + umUsuario.getNomeUsuario()
//					+ umUsuario.getSenha());
//		}

//		List<Amizade> itemsGroup = amigosMap.get(1);
//		for (Amizade item : itemsGroup) {
//			System.out.println(item.getUsuarioAmigo().getNomeCompleto() + "\n" + item.getUsuarioPrincipal().getNomeCompleto()+ "\n" + item.getIdAmizade());
//		}

//		List<Postagem> itemsGroup = postagemMap.get(3);
//		for (Postagem item : itemsGroup) {
//			System.out.println(item.getConteudo() + "\n" + item.getId() + "\n" + item.getIdUsuario());
//		}

//		for(Usuario usuario:usuarios) {
//			System.out.println("Completo: "+usuario.getNomeCompleto()+" Usuario: "+usuario.getNomeUsuario()+
//					" Senha: "+usuario.getSenha()+" Id: "+usuario.getId());
//		}

	}

}
