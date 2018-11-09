package screenGraphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import attributesCertified.Certified;
import connection.DeleteTableBD;
import connection.PeopleTableCertified;
import managerArchives.ExtractInformation;
import managerArchives.UploadArchives;
import tableJTable.CellRenderer;
import tableJTable.TableCertified;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ScreenCertified extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tTable;
	private JTextField txtFieldSearch;

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
		PeopleTableCertified peopleTable = new PeopleTableCertified();
		model.clearTable();
		peopleTable.readJTable(tTable, model);

		// Abstracao Coluna ID
		tTable.getColumnModel().getColumn(0).setMinWidth(0);
		tTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		tTable.getColumnModel().getColumn(0).setMaxWidth(0);

		// Bloquear Troca de Coluna
		tTable.getTableHeader().setReorderingAllowed(false);
		
		tTable.setAutoCreateRowSorter(true);
		//tTable.setRowSorter(sorter);
		
		
		// Criando os Botoes

		// Botao Deletar
		JButton btnDelete = new JButton("Deletar");
		btnDelete.setBounds(413, 438, 90, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Certified certified = new Certified();
				DeleteTableBD deleteTableBD = new DeleteTableBD();

				certified.setId((int) tTable.getValueAt(tTable.getSelectedRow(), 0));
				deleteTableBD.delete(certified);

				model.clearTable();
				peopleTable.readJTable(tTable, model);
				txtFieldSearch.setText("Digite aqui o nome do certificado a ser buscado");
			}
		});

		panel.add(btnDelete);

		// Botao Sair
		JButton btnExit = new JButton("Sair");
		btnExit.setBounds(634, 438, 90, 23);
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
					extractInformation.informationCertified(returnArchive, passwordArchive);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				PeopleTableCertified peopleTable = new PeopleTableCertified();
				model.clearTable();
				peopleTable.readJTable(tTable, model);
			}
		});
		panel.add(btnUpload);
		
		txtFieldSearch = new JTextField();
		txtFieldSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtFieldSearch.setText("");
			}
		});
		txtFieldSearch.setText("Digite aqui o nome do certificado a ser buscado");
		txtFieldSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtFieldSearch.setText("");
			}
		});
		txtFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				peopleTable.readJTableForName(tTable, model, txtFieldSearch.getText());
			}
		});
		txtFieldSearch.setBounds(110, 439, 293, 20);
		panel.add(txtFieldSearch);
		txtFieldSearch.setColumns(10);
	}
}