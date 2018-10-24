package telaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.security.auth.x500.X500Principal;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableCellRenderer;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;

import atributosCertificado.Certificado;
import builder.CertificadoBuilder;
import conexao.DeletarTabelaBD;
import conexao.PovoaTabela;
import gerenciadorArquivos.UploadArquivos;
import tabelaJTable.CellRenderer;
import tabelaJTable.TabelaCertificado;

public class TelaCertificado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tTabela;
	private JFileChooser fileOpen;
	private File selectedFile;
	private FileFilter filter;
	private FileInputStream fileInputStream;
	private String certifiedPassword;
	private String alias;
	private int ret;
	private KeyStore keyStore;
	private Enumeration<String> eAliases;
	private Certificate certified;
	private TabelaCertificado tabelaCertificado = new TabelaCertificado();
	private CertificadoBuilder builder = new CertificadoBuilder();
	private Certificado setarDadosCertificado;
	private X509Certificate cert;
	private X500Principal principal;
	private X500Name x500Name;
	private RDN cn;
	private RDN email;

	public TelaCertificado() {
		super("Datas Certificados");
		setSize(750, 507);
		setLocationRelativeTo(null);

		JPanel painel = new JPanel();
		TabelaCertificado modelo = new TabelaCertificado();

		painel.setBounds(0, 0, 450, 300);
		getContentPane().add(painel);
		painel.setLayout(null);

		// Adicionando a Tabela
		tTabela = new JTable();
		JScrollPane barraRolagem = new JScrollPane(tTabela);
		barraRolagem.setBounds(0, 0, 734, 427);
		// Deixando os Titulos Centralizados
		((DefaultTableCellRenderer) tTabela.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		// Deixando Celulas Centralizadas
		tTabela.setDefaultRenderer(Object.class, new CellRenderer());
		tTabela.setModel(modelo);
		painel.add(barraRolagem);
		// modelo.pegaValor(tTabela, modelo);
		PovoaTabela povoaTabela = new PovoaTabela();
		modelo.limparTabela();
		povoaTabela.readJTable(tTabela, modelo);
		// Criando os Botoes

		// Botao Deletar
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(216, 438, 90, 23);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Certificado certificado = new Certificado();
				DeletarTabelaBD deletarTabelaBD = new DeletarTabelaBD();
				
				certificado.setId((int) tTabela.getValueAt(tTabela.getSelectedRow(), 0));
				deletarTabelaBD.delete(certificado);
				
				modelo.limparTabela();
				povoaTabela.readJTable(tTabela, modelo);
			}
		});

		painel.add(btnDeletar);

		// Botao Sair
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(614, 438, 90, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painel.add(btnSair);

		// Botao de Upload
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(10, 438, 90, 23);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadArquivos uploadArquivos = new UploadArquivos();
				uploadArquivos.uploadArquivos(fileOpen, filter, ret, selectedFile, certifiedPassword, keyStore,
						eAliases, fileInputStream, alias, certified, cert, principal, x500Name, cn, email, tTabela,
						tabelaCertificado, builder, setarDadosCertificado);
				PovoaTabela povoaTabela = new PovoaTabela();
				modelo.limparTabela();
				povoaTabela.readJTable(tTabela, modelo);
			}
		});
		painel.add(btnUpload);

		// Botao de Atualizar
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(446, 438, 90, 23);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PovoaTabela povoaTabela = new PovoaTabela();
				modelo.limparTabela();
				povoaTabela.readJTable(tTabela, modelo);
			}
		});
		painel.add(btnAtualizar);
	}
}