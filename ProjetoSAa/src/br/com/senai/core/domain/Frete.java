package br.com.senai.core.domain;

import java.util.Objects;

public class Frete {
	private int codigo;
	
	private String nome;
	
	private String identificador;
	
	private double valorDoQuilometro;
	
	public Frete(String nome, String identificador, double valorDoQuilometro) {
		this.nome = nome;
		this.identificador = identificador;
		this.valorDoQuilometro = valorDoQuilometro;
	}
	
	public Frete(int codigo, String nome, String identificador, double valorDoQuilometro) {
		this(nome, identificador, valorDoQuilometro);
		this.codigo = codigo;
	}
	
	public boolean isJaPersistido() {
		return getCodigo() > 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public double getValorDoQuilometro() {
		return valorDoQuilometro;
	}

	public void setValorDoQuilometro(double valorDoQuilometro) {
		this.valorDoQuilometro = valorDoQuilometro;
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
		Frete other = (Frete) obj;
		return codigo == other.codigo;
	}
	
	public String toString() {
		return getNome();
	}
	
	
}
