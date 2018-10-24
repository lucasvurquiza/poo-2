package atributosCertificado;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bouncycastle.asn1.ASN1Encodable;

public class Certificado {
	private ASN1Encodable nome;
	private ASN1Encodable cpfCnpj;
	private Date dataEmissao;
	private Date dataValidade;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String nomeCertificado;
	private double tamanhoArquivo;
	private int id;
	
	public Certificado(ASN1Encodable nome, ASN1Encodable cpfCnpj, Date dataEmissao, Date dataValidade,
			String nomeCertificado, double tamanhoArquivo, int id) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.dataEmissao = dataEmissao;
		this.dataValidade = dataValidade;
		this.nomeCertificado = nomeCertificado;
		this.tamanhoArquivo = tamanhoArquivo;
		this.id = id;
	}
	
	public Certificado(int id, Date dataValidade, Date dataEmissao, String nomeCertificado) {
		super();
		this.id = id;
		this.dataValidade = dataValidade;
		this.dataEmissao = dataEmissao;
		this.nomeCertificado = nomeCertificado;
	}

	public Certificado() {

	}

	public ASN1Encodable getNome() {
		return nome;
	}

	public ASN1Encodable getCpfCnpj() {
		return cpfCnpj;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public String getNomeCertificado() {
		return nomeCertificado;
	}

	public double getTamanhoArquivo() {
		return tamanhoArquivo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(ASN1Encodable asn1Encodable) {
		this.nome = asn1Encodable;
	}

	public void setCpfCnpj(ASN1Encodable asn1Encodable) {
		this.cpfCnpj = asn1Encodable;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public void setNomeCertificado(String nomeCertificado) {
		this.nomeCertificado = nomeCertificado;
	}

	public void setTamanhoArquivo(double tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Certificado [getNome()=" + getNome() + ", getCpfCnpj()=" + getCpfCnpj() + ", getDataEmissao()="
				+ dateFormat.format(getDataEmissao()) + ", getDataValidade()=" + dateFormat.format(getDataValidade()) + ", getNomeCertificado()="
				+ getNomeCertificado() + ", getTamanhoArquivo()="
				+ getTamanhoArquivo() + getId() + "]";
	}	
}
