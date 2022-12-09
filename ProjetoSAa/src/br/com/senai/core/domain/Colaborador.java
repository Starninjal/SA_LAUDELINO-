package br.com.senai.core.domain;

import java.util.Objects;

public class Colaborador {
	private int codigo;
	
	private String nomeCompleto;
	
	public Colaborador(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Colaborador(int codigo, String nomeCompleto) {
		this(nomeCompleto);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
		Colaborador other = (Colaborador) obj;
		return codigo == other.codigo;
	}
	
	public String toString() {
		return getNomeCompleto();
	}
	
	
	
}
