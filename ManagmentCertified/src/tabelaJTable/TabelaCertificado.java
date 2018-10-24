package tabelaJTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.bouncycastle.asn1.ASN1Encodable;

import atributosCertificado.Certificado;

public class TabelaCertificado extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Certificado> dados;
	private String[] colunas = { "ID", "Nome", "CPF / CNPJ", "Data Emissão", "Data Validade", "Nome Certificado" };

	public TabelaCertificado() {
		this.dados = new ArrayList<Certificado>();
	}

	public void addRow(Certificado t) {
		this.dados.add(t);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public int getColumnCount() {
		return this.colunas.length;
	}

	public String getColumnName(int col) {
		return this.colunas[col];
	}

	@Override
	public int getRowCount() {
		return this.dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return this.dados.get(linha).getId();
		case 1:
			return this.dados.get(linha).getNome();
		case 2:
			return this.dados.get(linha).getCpfCnpj();
		case 3:
			return this.dados.get(linha).getDataValidade();
		case 4:
			return this.dados.get(linha).getDataEmissao();
		case 5:
			return this.dados.get(linha).getNomeCertificado();
		}
		return null;
	}

	public ArrayList<Certificado> getCertificado() {
		return this.dados;
	}

	public Certificado getRowAt(int linha) {
		return this.dados.get(linha);
	}

	public void pegaValor(JTable tTabela, TabelaCertificado modelo) {

		tTabela.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ASN1Encodable valor = (ASN1Encodable) tTabela.getModel().getValueAt(tTabela.getSelectedRow(),
						tTabela.getSelectedColumn());
				String aux = String.valueOf(valor);
				System.out.println(aux);
			}
		});
	}

	public void limparTabela() {
		dados.clear();
	}

}