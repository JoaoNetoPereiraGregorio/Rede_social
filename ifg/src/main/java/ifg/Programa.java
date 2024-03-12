package ifg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Programa {

	public static void main(String[] args) throws SQLException {

//		Connection cnx = DataBase.getConnection();
//		cnx.setAutoCommit(false);// apagar
//		try {
//			PreparedStatement insert = cnx.prepareStatement("insert into pessoas(nome) values ('jose');",
//					Statement.RETURN_GENERATED_KEYS);
//			insert.execute();
//
//			ResultSet keys = insert.getGeneratedKeys();
//			keys.next();
//			long idPessoa = keys.getLong(1);
//
//			PreparedStatement insertContato = cnx
//					.prepareStatement("insert into contato(id, id_pessoa, contato) values ('3',"+idPessoa+",'5432154445');");
//			insertContato.execute();
//			cnx.commit();// apagar
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//
		 //insert("insert into pessoas(nome) values ('lucas')");
		//delete("delete from pessoas where nome='joao'");
		 //"update categorias set nome ='esport' where nome = 'esporte'");
		java.sql.ResultSet rs = select("select *  from usuario;");
		while (rs.next()) {
			System.out.println("Nome usuario: "+rs.getString("nome_usuario")+"  Nome completo: "+rs.getString("nome_completo"));
	}
	}

	public static ResultSet select(String query) throws SQLException {
		Connection cnx = DataBase.getConnection();
		ResultSet rs = null;
		try {

			PreparedStatement ps = cnx.prepareStatement(query);

			rs = ps.executeQuery();

//	        	while(rs.next()) {
//	        		System.out.println(rs.getString("id")+"  "+rs.getString("nome"));
//	        	}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return rs;

	}

	public static void insert(String query) throws SQLException {
		Connection cnx = DataBase.getConnection();
		try {
			PreparedStatement insert = cnx.prepareStatement(query);
			insert.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static void delete(String query) throws SQLException {
		Connection cnx = DataBase.getConnection();
		try {

			PreparedStatement delete = cnx.prepareStatement(query);
			delete.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void uptade(String query) throws SQLException {
		Connection cnx = DataBase.getConnection();
		try {

			PreparedStatement update = cnx.prepareStatement(query);
			update.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
