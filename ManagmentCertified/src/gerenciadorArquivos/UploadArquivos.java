package gerenciadorArquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.security.auth.x500.X500Principal;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;

import atributosCertificado.Certificado;
import builder.CertificadoBuilder;
import conexao.SalvarInformacoesBancoDados;
import tabelaJTable.TabelaCertificado;
import telaGrafica.PopUpSenhaCertificado;

public class UploadArquivos {

	public void uploadArquivos(JFileChooser fileOpen, FileFilter filter, int ret, File selectedFile,
			String certifiedPassword, KeyStore keyStore, Enumeration<String> eAliases, FileInputStream fileInputStream,
			String alias, Certificate certified, X509Certificate cert, X500Principal principal, X500Name x500Name,
			RDN cn, RDN email, JTable tTabela, TabelaCertificado tabelaCertificado, CertificadoBuilder builder,
			Certificado setarDadosCertificado) {
		fileOpen = new JFileChooser();
		filter = new FileNameExtensionFilter("Certificados PFX", "pfx");
		fileOpen.addChoosableFileFilter(filter);
		ret = fileOpen.showDialog(null, "Upload Arquivo");

		if (ret == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileOpen.getSelectedFile();
			PopUpSenhaCertificado telaSenhaCertificado = new PopUpSenhaCertificado();
			telaSenhaCertificado.mostraPopUp();
			certifiedPassword = telaSenhaCertificado.getPassword();

			try {
				keyStore = KeyStore.getInstance(("PKCS12"));
				keyStore.load(new FileInputStream(selectedFile), certifiedPassword.toCharArray());
				eAliases = keyStore.aliases();
				fileInputStream = new FileInputStream(selectedFile);

				while (eAliases.hasMoreElements()) {
					alias = (String) eAliases.nextElement();
					certified = (Certificate) keyStore.getCertificate(alias);
					cert = (X509Certificate) certified;
					principal = cert.getSubjectX500Principal();
					x500Name = new X500Name(principal.getName());
					cn = x500Name.getRDNs(BCStyle.CN)[0];
					email = x500Name.getRDNs(BCStyle.C)[0];

					setarDadosCertificado = builder.hasNome(cn.getFirst().getValue())
							.hasCpfCnpj(email.getFirst().getValue()).hasDataEmissao(cert.getNotBefore())
							.hasDataValidade(cert.getNotAfter()).hasNomeCertificado(selectedFile.getName())
							.hasTamanhoArquivo(selectedFile.length()).build();

					SalvarInformacoesBancoDados persisteBD = new SalvarInformacoesBancoDados();
					persisteBD.persisteBD(setarDadosCertificado, fileInputStream, selectedFile);

				}
				// while (certifiedPassword.equals("") || certifiedPassword.equals(null)) {}

			} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Digite uma senha valida", "Senha Incorreta",
						JOptionPane.ERROR_MESSAGE);
				telaSenhaCertificado.mostraPopUp();
			}

		}
	}
}