package br.com.senai.core.dao.postgresql;

import java.sql.Connection;

import br.com.senai.core.dao.DaoEntrega;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Entrega;

public class DaoPostgresqlEntrega implements DaoEntrega{

	private final String INSERT = "INSERT INTO entregas (data_saida, data_chegada, km_percorrido, horaDeChegada, horaDeSaida, valorTotal, observacoes) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private Connection conexao;
	
	public DaoPostgresqlEntrega() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	public void inserir(Entrega entrega) {
		
		
	}
	
}
