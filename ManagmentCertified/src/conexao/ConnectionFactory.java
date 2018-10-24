package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/gerenciamentoCertificadoDigital";;
	private static final String USER = "postgres";
	private static final String PASS = "123";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conex�o: ", ex);
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}