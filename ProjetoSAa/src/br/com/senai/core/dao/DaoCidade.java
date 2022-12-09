package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Cidade;


public interface DaoCidade {
	
	public void inserir(Cidade cidade);
	
	public void alterar(Cidade cidade);
	
	public void excluirPor(int id);
	
	public List<Cidade> listarPor(String nomeCompleto);

	public List<Cidade> listarTodas();
	
}
