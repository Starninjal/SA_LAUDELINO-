package br.com.senai.core.domain;

import java.util.Objects;

public class Endereco {
	
	private int codigo;
	
	private String CEP;
	
	private String logradouro;
	
	private String complemento;
	
	private int numero;
	
	private Cidade cidade;
	
	

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Endereco(String CEP, String logradouro, String complemento, int numero, Cidade cidade) {
		this.CEP = CEP;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.cidade = cidade;
	}
	
	public Endereco(int codigo, String CEP, String logradouro, String complemento, int numero, Cidade cidade) {
		this(CEP, logradouro, complemento, numero, cidade);
		this.codigo = codigo;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public boolean isJaPersistido() {
		return getCodigo() > 0;
	}

	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return codigo == other.codigo;
	}
	
	
	public String toString() {
		return getLogradouro();
	}
	
	
	
	
}
