package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;

import attributesCertified.Certified;
import tableJTable.TableCertified;

public class PeopleTableCertified {
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
			Logger.getLogger(PeopleTableCertified.class.getName()).log(Level.SEVERE, null, e);// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return certificates;
	}

	public ArrayList<Certified> readForName(String name) {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Certified> certificates = new ArrayList<>();

		try {
			stmt = con.prepareStatement(
					"SELECT id, validade, emissao, nomearquivo FROM gerenciadorcertificadodigital.certificados WHERE LOWER(nomearquivo) LIKE ?");
			stmt.setString(1, "%"+ name +"%");
			
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
			Logger.getLogger(PeopleTableCertified.class.getName()).log(Level.SEVERE, null, e);// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return certificates;
	}
	
	public void readJTable(JTable tTabela, TableCertified model) {
		PeopleTableCertified peopleTable = new PeopleTableCertified();
		
		for (Certified certificates : peopleTable.read()) {
			model.addRow(certificates);
		}
	}
	
	public void readJTableForName(JTable tTabela, TableCertified model, String name) {
		PeopleTableCertified peopleTable = new PeopleTableCertified();
		model.clearTable();		
		for (Certified certificates : peopleTable.readForName(name)) {
			model.addRow(certificates);
		}
	}
}
