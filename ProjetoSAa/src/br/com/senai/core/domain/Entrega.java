package br.com.senai.core.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Entrega {
	
	private int codigo;
	
	private LocalDate dataDeSaida;
	
	private LocalDate horaDeSaida;
	
	private LocalDate dataDeChegada;
	
	private LocalDate horaDeChegada;
	
	private double kmPercorrido;
	
	private double valorTotal;
	
	private String observacoes;
	
	private Colaborador colaborador;
	
	private Frete frete;
	
	private Endereco endereco;

	public Entrega(LocalDate dataDeSaida, LocalDate horaDeSaida, LocalDate dataDeChegada,
			LocalDate horaDeChegada, double kmPercorrido, double valorTotal, String observacoes, Colaborador colaborador,
			Frete frete, Endereco endereco) {
		this.dataDeSaida = dataDeSaida;
		this.horaDeSaida = horaDeSaida;
		this.dataDeChegada = dataDeChegada;
		this.horaDeChegada = horaDeChegada;
		this.kmPercorrido = kmPercorrido;
		this.valorTotal = valorTotal;
		this.observacoes = observacoes;
		this.colaborador = colaborador;
		this.frete = frete;
		this.endereco = endereco;
	}
	
	public Entrega(int codigo, LocalDate dataDeSaida, LocalDate horaDeSaida, LocalDate dataDeChegada,
			LocalDate horaDeChegada, double kmPercorrido, double valorTotal, String observacoes, Colaborador colaborador,
			Frete frete, Endereco endereco) {
		this(dataDeSaida, horaDeSaida, dataDeChegada, horaDeChegada, kmPercorrido, valorTotal, observacoes, colaborador, frete, endereco);
		this.codigo = codigo;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(LocalDate dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public LocalDate getHoraDeSaida() {
		return horaDeSaida;
	}

	public void setHoraDeSaida(LocalDate horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
	}

	public LocalDate getDataDeChegada() {
		return dataDeChegada;
	}

	public void setDataDeChegada(LocalDate dataDeChegada) {
		this.dataDeChegada = dataDeChegada;
	}

	public LocalDate getHoraDeChegada() {
		return horaDeChegada;
	}

	public void setHoraDeChegada(LocalDate horaDeChegada) {
		this.horaDeChegada = horaDeChegada;
	}

	public double getKmPercorrido() {
		return kmPercorrido;
	}

	public void setKmPercorrido(double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		Entrega other = (Entrega) obj;
		return codigo == other.codigo;
	}
	
	
	
	
	
	
}
