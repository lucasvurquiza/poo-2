package screenGraphic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import tableJTable.CellRenderer;
import tableJTable.TableClient;

import javax.swing.JButton;

public class ClientTab extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFieldCpfCnpj;
	private JTextField txtFieldName;
	private JTextField txtFieldComplement;
	private JTextField txtFieldNumber;
	private JTextField txtFieldAddress;
	private JTextField txtFieldContact;
	private JTextField txtFieldEmail;
	private JTextField txtFieldPhone;
	private JTable tTable;
	
	public ClientTab() {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 328, 303);
		getContentPane().add(tabbedPane);
		
		JPanel panelBasicsData = new JPanel();
		tabbedPane.addTab("Dados Basicos", null, panelBasicsData, null);
		panelBasicsData.setLayout(null);
		
		JLabel lblCpfCnpj = new JLabel("CPF / CNPJ:");
		lblCpfCnpj.setBounds(10, 32, 64, 14);
		panelBasicsData.add(lblCpfCnpj);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setBounds(10, 66, 46, 14);
		panelBasicsData.add(lblName);
		
		txtFieldCpfCnpj = new JTextField();
		txtFieldCpfCnpj.setBounds(72, 29, 241, 20);
		panelBasicsData.add(txtFieldCpfCnpj);
		txtFieldCpfCnpj.setColumns(10);
		
		txtFieldName = new JTextField();
		txtFieldName.setColumns(10);
		txtFieldName.setBounds(72, 63, 241, 20);
		panelBasicsData.add(txtFieldName);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.setBounds(117, 108, 89, 23);
		panelBasicsData.add(btnSave);
		
		JPanel panelAddress = new JPanel();
		tabbedPane.addTab("Endereco", null, panelAddress, null);
		panelAddress.setLayout(null);
		
		JLabel lblAddress = new JLabel("Logradouro:");
		lblAddress.setBounds(10, 11, 66, 14);
		panelAddress.add(lblAddress);
		
		JLabel lblNumber = new JLabel("Numero:");
		lblNumber.setBounds(10, 64, 46, 14);
		panelAddress.add(lblNumber);
		
		JLabel lblComplement = new JLabel("Complemento:");
		lblComplement.setBounds(10, 115, 78, 14);
		panelAddress.add(lblComplement);
		
		txtFieldComplement = new JTextField();
		txtFieldComplement.setBounds(82, 112, 231, 20);
		panelAddress.add(txtFieldComplement);
		txtFieldComplement.setColumns(10);
		
		txtFieldNumber = new JTextField();
		txtFieldNumber.setColumns(10);
		txtFieldNumber.setBounds(82, 61, 231, 20);
		panelAddress.add(txtFieldNumber);
		
		txtFieldAddress = new JTextField();
		txtFieldAddress.setColumns(10);
		txtFieldAddress.setBounds(82, 8, 231, 20);
		panelAddress.add(txtFieldAddress);
		
		JPanel panelContact = new JPanel();
		tabbedPane.addTab("Contato", null, panelContact, null);
		panelContact.setLayout(null);
		
		TableClient tableClient = new TableClient();
		tTable = new JTable();
		JScrollPane rollBar = new JScrollPane(tTable);
		rollBar.setBounds(10, 86, 300, 187);	
		
		((DefaultTableCellRenderer) tTable.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(SwingConstants.CENTER);
		
		tTable.setDefaultRenderer(Object.class, new CellRenderer());
		tTable.setModel(tableClient);
		panelContact.add(rollBar);
		
		
		
		JLabel lblContact = new JLabel("Contato:");
		lblContact.setBounds(10, 11, 46, 14);
		panelContact.add(lblContact);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setBounds(10, 36, 46, 14);
		panelContact.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Telefone:");
		lblPhone.setBounds(10, 61, 46, 14);
		panelContact.add(lblPhone);
		
		txtFieldContact = new JTextField();
		txtFieldContact.setBounds(58, 8, 255, 20);
		panelContact.add(txtFieldContact);
		txtFieldContact.setColumns(10);
		
		txtFieldEmail = new JTextField();
		txtFieldEmail.setColumns(10);
		txtFieldEmail.setBounds(58, 33, 255, 20);
		panelContact.add(txtFieldEmail);
		
		txtFieldPhone = new JTextField();
		txtFieldPhone.setColumns(10);
		txtFieldPhone.setBounds(58, 58, 140, 20);
		panelContact.add(txtFieldPhone);
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setBounds(224, 57, 89, 23);
		panelContact.add(btnAdd);
		
	}
}
