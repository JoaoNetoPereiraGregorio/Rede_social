package ifg;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	public static Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/rede_social","root","08192119");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conexao;

	}

	public static void main(String[] args) {
		Connection c = new DataBase().getConnection();
		System.out.println(c);
	}

}
