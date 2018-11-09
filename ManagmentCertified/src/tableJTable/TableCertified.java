package tableJTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.bouncycastle.asn1.ASN1Encodable;

import attributesCertified.Certified;

public class TableCertified extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Certified> data;
	private String[] columns = { "ID", "Nome", "CPF / CNPJ", "Data Emissão", "Data Validade", "Nome Certificado" };

	public TableCertified() {
		this.data = new ArrayList<Certified>();
	}

	public void addRow(Certified t) {
		this.data.add(t);
		this.fireTableDataChanged();
	}

	public void deleteRow(int linha) {
		this.data.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public int getColumnCount() {
		return this.columns.length;
	}

	public String getColumnName(int col) {
		return this.columns[col];
	}

	@Override
	public int getRowCount() {
		return this.data.size();
	}

	@Override
	public Object getValueAt(int line, int columns) {
		switch (columns) {
		case 0:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getId() : null);
		case 1:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getName() : null);
		case 2:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getCpfCnpj() : null);
		case 3:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getValidityDate() : null);
		case 4:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getEmissionDate() : null);
		case 5:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getNameCertified() : null);
		}
		return null;
	}

	public ArrayList<Certified> getCertified() {
		return this.data;
	}

	public Certified getRowAt(int line) {
		return this.data.get(line);
	}

	public void takeValue(JTable tTable, TableCertified model) {

		tTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ASN1Encodable value = (ASN1Encodable) tTable.getModel().getValueAt(tTable.getSelectedRow(),
						tTable.getSelectedColumn());
				String aux = String.valueOf(value);
				System.out.println(aux);
			}
		});
	}

	public void clearTable() {
		fireTableDataChanged();
		data.clear();
	}
}