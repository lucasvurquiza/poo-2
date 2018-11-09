package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import attributesCertified.Certified;

public class DeleteTableBD {
	public void delete(Certified certificado) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
	
		try {
			stmt = con.prepareStatement("DELETE FROM gerenciadorcertificadodigital.certificados WHERE id = ?");
			stmt.setInt(1, certificado.getId());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Excluido com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Nao foi possivel excluir");
			// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
