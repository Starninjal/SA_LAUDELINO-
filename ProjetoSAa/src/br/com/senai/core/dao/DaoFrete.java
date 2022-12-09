package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Frete;

public interface DaoFrete {
	
	public void inserir(Frete frete);
	
	public void alterar(Frete frete);
	
	public void excluirPor(int id);
	
	public List<Frete> listarPor(String nome);
	
	public List<Frete> listarTodas();
}
