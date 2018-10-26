package telaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import atributosCertificado.Certified;
import conexao.DeleteTableBD;
import conexao.PeopleTable;
import gerenciadorArquivos.ExtractInformation;
import gerenciadorArquivos.UploadArchives;
import tabelaJTable.CellRenderer;
import tabelaJTable.TableCertified;

public class ScreenCertified extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tTable;

	public ScreenCertified() {
		super("Datas Certificados");
		setSize(750, 507);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		TableCertified model = new TableCertified();

		panel.setBounds(0, 0, 450, 300);
		getContentPane().add(panel);
		panel.setLayout(null);

		// Adicionando a Tabela
		tTable = new JTable();
		JScrollPane rollBar = new JScrollPane(tTable);
		rollBar.setBounds(0, 0, 734, 427);
		// Deixando os Titulos Centralizados
		((DefaultTableCellRenderer) tTable.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(SwingConstants.CENTER);
		// Deixando Celulas Centralizadas
		tTable.setDefaultRenderer(Object.class, new CellRenderer());
		tTable.setModel(model);
		panel.add(rollBar);
		// modelo.pegaValor(tTabela, modelo);
		PeopleTable peopleTable = new PeopleTable();
		model.clearTable();
		peopleTable.readJTable(tTable, model);
		// Criando os Botoes

		// Botao Deletar
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setBounds(216, 438, 90, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Certified certified = new Certified();
				DeleteTableBD deleteTableBD = new DeleteTableBD();

				certified.setId((int) tTable.getValueAt(tTable.getSelectedRow(), 0));
				deleteTableBD.delete(certified);

				model.clearTable();
				peopleTable.readJTable(tTable, model);
			}
		});

		panel.add(btnDelete);

		// Botao Sair
		JButton btnExit = new JButton("Sair");
		btnExit.setBounds(614, 438, 90, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnExit);

		// Botao de Upload
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(10, 438, 90, 23);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UploadArchives uploadArchives = new UploadArchives();		
				File returnArchive = uploadArchives.returnArchive();
				PopUpPasswordCertified popUpPasswordCertified = new PopUpPasswordCertified();
				String passwordArchive = popUpPasswordCertified.showPopUp();

				ExtractInformation extractInformation = new ExtractInformation();
				
				try {
					extractInformation.informacoesCertificado(returnArchive, passwordArchive);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				PeopleTable peopleTable = new PeopleTable();
				model.clearTable();
				peopleTable.readJTable(tTable, model);
			}
		});
		panel.add(btnUpload);

		// Botao de Atualizar
		JButton btnUpdate = new JButton("Atualizar");
		btnUpdate.setBounds(446, 438, 90, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PeopleTable peopleTable = new PeopleTable();
				model.clearTable();
				peopleTable.readJTable(tTable, model);
			}
		});
		panel.add(btnUpdate);
	}
}