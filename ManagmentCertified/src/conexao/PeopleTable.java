package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;

import atributosCertificado.Certified;
import tabelaJTable.TableCertified;

public class PeopleTable {
	public ArrayList<Certified> read() {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Certified> certificates = new ArrayList<>();

		try {
			stmt = con.prepareStatement(
					"SELECT id, validade, emissao, nomearquivo FROM gerenciadorcertificadodigital.certificados");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Certified certified = new Certified();
				certified.setId(rs.getInt("id"));
				certified.setValidityDate(rs.getDate("validade"));
				certified.setEmissionDate(rs.getDate("emissao"));
				certified.setNomeCertificado(rs.getString("nomearquivo"));
				certificates.add(certified);
			}
		} catch (SQLException e) {
			Logger.getLogger(PeopleTable.class.getName()).log(Level.SEVERE, null, e);// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return certificates;
	}

	public void readJTable(JTable tTabela, TableCertified model) {
		PeopleTable peopleTable = new PeopleTable();

		for (Certified certificates : peopleTable.read()) {
			model.addRow(certificates);
		}
	}
}
