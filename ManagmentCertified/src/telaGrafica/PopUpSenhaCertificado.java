package telaGrafica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PopUpSenhaCertificado extends JPanel {
	private static final long serialVersionUID = 1L;
	private String password;

	@SuppressWarnings("deprecation")
	/*
	 * public PopUpSenhaCertificado() { JPasswordField jPasswordField = new
	 * JPasswordField(); jPasswordField.setBounds(115, 5, 119, 20); JLabel jLabel =
	 * new JLabel("Digite a senha: "); jLabel.setBounds(10, 8, 95, 14); JPanel
	 * jPanel = new JPanel(); jPanel.setLayout(null); jPanel.add(jLabel);
	 * jPanel.add(jPasswordField);
	 * 
	 * JOptionPane.showConfirmDialog(null, new Object[] { jLabel, jPasswordField },
	 * "Senha Certificado", JOptionPane.OK_CANCEL_OPTION,
	 * JOptionPane.PLAIN_MESSAGE);
	 * 
	 * String senha = jPasswordField.getText(); setPassword(senha); }
	 */

	public void mostraPopUp() {
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setBounds(115, 5, 119, 20);
		JLabel jLabel = new JLabel("Digite a senha: ");
		jLabel.setBounds(10, 8, 95, 14);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		jPanel.add(jLabel);
		jPanel.add(jPasswordField);

		final int option = JOptionPane.showConfirmDialog(null, new Object[] { jLabel, jPasswordField }, "Senha Certificado",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
		if(option!=JOptionPane.CANCEL_OPTION) {
				if (jPasswordField.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite uma senha valida", "Senha Incorreta",
					JOptionPane.ERROR_MESSAGE);
			mostraPopUp();

		} else {
			String senha = jPasswordField.getText();
			setPassword(senha);	
		}
		
	}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
