package br.com.senai.core.domain;

import java.util.Objects;

public class Cidade {
	
	private int codigo;
	
	private String nome; 
	
	private String uf;
	
	private int idCidade;
	
	
	

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public Cidade(String nome, String uf) {

		this.nome = nome;
		this.uf = uf;
	}
	
	public Cidade(int codigo, String nome, String uf) {
		this(nome, uf);
		this.codigo = codigo;
	
	}
	
	public boolean isJaPersistido() {
		return getCodigo() > 0;
	}

	public int getCodigo() {
		return codigo;
	}

	
	
	public void setId(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Cidade other = (Cidade) obj;
		return codigo == other.codigo;
	}
	
	public String toString() {
		return getNome();
	}
	
	

}
