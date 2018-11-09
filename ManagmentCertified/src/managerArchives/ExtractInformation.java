package managerArchives;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;

import attributesCertified.Certified;
import builder.CertifiedBuilder;
import connection.SaveInformationBD;

public class ExtractInformation {

	public void informationCertified(File selectArchive, String password) throws FileNotFoundException {
		int ret = 0;
		if (ret == JFileChooser.APPROVE_OPTION) {
			try {
				KeyStore keyStore = KeyStore.getInstance(("PKCS12"));
				keyStore.load(new FileInputStream(selectArchive), password.toCharArray());
				Enumeration<String> eAliases = keyStore.aliases();
				FileInputStream fileInputStream = new FileInputStream(selectArchive);

				while (eAliases.hasMoreElements()) {
					String alias = (String) eAliases.nextElement();
					Certificate certified = (Certificate) keyStore.getCertificate(alias);
					X509Certificate cert = (X509Certificate) certified;
					X500Principal principal = cert.getSubjectX500Principal();
					X500Name x500Name = new X500Name(principal.getName());
					RDN cn = x500Name.getRDNs(BCStyle.CN)[0];
					;
					RDN email = x500Name.getRDNs(BCStyle.C)[0];

					Certified setDataCertified = new Certified();
					CertifiedBuilder builder = new CertifiedBuilder();

					setDataCertified = builder.hasNome(cn.getFirst().getValue()).hasCpfCnpj(email.getFirst().getValue())
							.hasEmissionDate(cert.getNotBefore()).hasValidityDate(cert.getNotAfter())
							.hasNameCertified(selectArchive.getName()).hasSizeArchive(selectArchive.length()).build();

					SaveInformationBD saveInformationBD = new SaveInformationBD();
					saveInformationBD.saveInformationBD(setDataCertified, fileInputStream, selectArchive);
				}

			} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
				JOptionPane.showMessageDialog(null, " Mensagem para o usúario", " Título", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"   A senha digitada esta incorreta!\nPor favor, faça o upload novamente!", " Senha Incorreta",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
