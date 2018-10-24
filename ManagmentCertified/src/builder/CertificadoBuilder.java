package builder;

import java.util.Date;

import org.bouncycastle.asn1.ASN1Encodable;

import atributosCertificado.Certificado;

public class CertificadoBuilder {
	private ASN1Encodable nome;
	private ASN1Encodable cpfCnpj;
	private Date dataEmissao;
	private Date dataValidade;
	private String nomeCertificado;
	private double tamanhoArquivo;
	private int id;
	
	public CertificadoBuilder hasNome(ASN1Encodable nome) {
		this.nome = nome;
		return this;
	}

	public CertificadoBuilder hasCpfCnpj(ASN1Encodable cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
		return this;
	}

	public CertificadoBuilder hasDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
		return this;
	}

	public CertificadoBuilder hasDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
		return this;
	}
	
	public CertificadoBuilder hasNomeCertificado(String nomeCertificado) {
		this.nomeCertificado = nomeCertificado;
		return this;
	}
	
	public CertificadoBuilder hasTamanhoArquivo(double tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
		return this;
	}
	
	public CertificadoBuilder hasId(int id) {
		this.id = id;
		return this;
	}

	public Certificado build() {
		return new Certificado(nome, cpfCnpj, dataEmissao, dataValidade, nomeCertificado, tamanhoArquivo, id);
	}

}
