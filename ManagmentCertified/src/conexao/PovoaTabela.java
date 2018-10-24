package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;

import atributosCertificado.Certificado;
import tabelaJTable.TabelaCertificado;

public class PovoaTabela {
	public ArrayList<Certificado> read() {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Certificado> certificados = new ArrayList<>();

		try {
			stmt = con.prepareStatement(
					"SELECT id, validade, emissao, nomearquivo FROM gerenciadorcertificadodigital.certificados");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Certificado certificado = new Certificado();
				certificado.setId(rs.getInt("id"));
				certificado.setDataValidade(rs.getDate("validade"));
				certificado.setDataEmissao(rs.getDate("emissao"));
				certificado.setNomeCertificado(rs.getString("nomearquivo"));
				certificados.add(certificado);
			}
		} catch (SQLException e) {
			Logger.getLogger(PovoaTabela.class.getName()).log(Level.SEVERE, null, e);// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return certificados;
	}

	public void readJTable(JTable tTabela, TabelaCertificado modelo) {
		PovoaTabela povoaTabela = new PovoaTabela();

		for (Certificado cerficados : povoaTabela.read()) {
			modelo.addRow(cerficados);
		}
	}
}
