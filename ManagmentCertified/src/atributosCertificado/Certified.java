package atributosCertificado;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bouncycastle.asn1.ASN1Encodable;

public class Certified {
	private ASN1Encodable name;
	private ASN1Encodable cpfCnpj;
	private Date emissionDate;
	private Date validityDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String nameCertified;
	private double sizeArchive;
	private int id;
	
	public Certified(ASN1Encodable name, ASN1Encodable cpfCnpj, Date emissionDate, Date validityDate,
			String nameCertified, double sizeArchive, int id) {
		super();
		this.name = name;
		this.cpfCnpj = cpfCnpj;
		this.emissionDate = emissionDate;
		this.validityDate = validityDate;
		this.nameCertified = nameCertified;
		this.sizeArchive = sizeArchive;
		this.id = id;
	}
	
	public Certified(int id, Date validityDate, Date emissionDate, String nameCertified) {
		super();
		this.id = id;
		this.validityDate = validityDate;
		this.emissionDate = emissionDate;
		this.nameCertified = nameCertified;
	}

	public Certified() {

	}

	public ASN1Encodable getName() {
		return name;
	}

	public ASN1Encodable getCpfCnpj() {
		return cpfCnpj;
	}

	public Date getEmissionDate() {
		return emissionDate;
	}

	public Date getValidityDate() {
		return validityDate;
	}

	public String getNameCertified() {
		return nameCertified;
	}

	public double getSizeArchive() {
		return sizeArchive;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(ASN1Encodable asn1Encodable) {
		this.name = asn1Encodable;
	}

	public void setCpfCnpj(ASN1Encodable asn1Encodable) {
		this.cpfCnpj = asn1Encodable;
	}

	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	public void setNomeCertificado(String nameCertified) {
		this.nameCertified = nameCertified;
	}

	public void setTamanhoArquivo(double sizeArchive) {
		this.sizeArchive = sizeArchive;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Certificado [getNome()=" + getName() + ", getCpfCnpj()=" + getCpfCnpj() + ", getDataEmissao()="
				+ dateFormat.format(getEmissionDate()) + ", getDataValidade()=" + dateFormat.format(getValidityDate()) + ", getNomeCertificado()="
				+ getNameCertified() + ", getTamanhoArquivo()="
				+ getSizeArchive() + getId() + "]";
	}	
}
