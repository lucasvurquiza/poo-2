package conexao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import atributosCertificado.Certified;

public class SaveInformationBD {
	public void saveInformationBD(Certified setDataCertified, FileInputStream fileInputStream, File selectedFile) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO gerenciadorcertificadodigital.certificados(validade, emissao, nomearquivo, arquivo)"
							+ "VALUES (?, ?, ?, ?)");
			stmt.setDate(1, new java.sql.Date(setDataCertified.getEmissionDate().getTime()));
			stmt.setDate(2, new java.sql.Date(setDataCertified.getValidityDate().getTime()));
			stmt.setString(3, setDataCertified.getNameCertified());
			stmt.setBinaryStream(4, fileInputStream, (int) selectedFile.length());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}