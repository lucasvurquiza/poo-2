package tableJTable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import attributesClient.Client;

public class TableClient extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Client> data;
	private String[] columns = { "ID", "Contato", "e-mail", "Telefone"};
	
	public TableClient() {
		this.data = new ArrayList<Client>();
	}
	
	public void addRow(Client t) {
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
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getNameContact() : null);
		case 1:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getEmailContact() : null);
		case 2:
			return (this.data != null && !this.data.isEmpty() ? this.data.get(line).getPhoneContact() : null);
		}
		return null;
	}
	
	public ArrayList<Client> getCertified() {
		return this.data;
	}
	
	public Client getRowAt(int line) {
		return this.data.get(line);
	}
	
	public void clearTable() {
		fireTableDataChanged();
		data.clear();
	}
}
