package conexao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import atributosCertificado.Certificado;

public class SalvarInformacoesBancoDados {
	public void persisteBD(Certificado setarDadosCertificado, FileInputStream fileInputStream, File selectedFile) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO gerenciadorcertificadodigital.certificados(validade, emissao, nomearquivo, arquivo)"
							+ "VALUES (?, ?, ?, ?)");
			stmt.setDate(1, new java.sql.Date(setarDadosCertificado.getDataEmissao().getTime()));
			stmt.setDate(2, new java.sql.Date(setarDadosCertificado.getDataValidade().getTime()));
			stmt.setString(3, setarDadosCertificado.getNomeCertificado());
			stmt.setBinaryStream(4, fileInputStream, (int) selectedFile.length());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}