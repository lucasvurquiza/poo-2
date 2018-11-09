package builder;

import java.util.Date;

import org.bouncycastle.asn1.ASN1Encodable;

import attributesCertified.Certified;

public class CertifiedBuilder {
	private ASN1Encodable name;
	private ASN1Encodable cpfCnpj;
	private Date emissionDate;
	private Date validityDate;
	private String nameCertified;
	private double sizeArchive;
	private int id;
	
	public CertifiedBuilder hasNome(ASN1Encodable name) {
		this.name = name;
		return this;
	}

	public CertifiedBuilder hasCpfCnpj(ASN1Encodable cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
		return this;
	}

	public CertifiedBuilder hasEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
		return this;
	}

	public CertifiedBuilder hasValidityDate(Date validityDate) {
		this.validityDate = validityDate;
		return this;
	}
	
	public CertifiedBuilder hasNameCertified(String nameCertified) {
		this.nameCertified = nameCertified;
		return this;
	}
	
	public CertifiedBuilder hasSizeArchive(double sizeArchive) {
		this.sizeArchive = sizeArchive;
		return this;
	}
	
	public CertifiedBuilder hasId(int id) {
		this.id = id;
		return this;
	}

	public Certified build() {
		return new Certified(name, cpfCnpj, emissionDate, validityDate, nameCertified, sizeArchive, id);
	}

}
