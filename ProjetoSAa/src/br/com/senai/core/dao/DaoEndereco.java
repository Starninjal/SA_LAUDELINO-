package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Cidade;
import br.com.senai.core.domain.Endereco;

public interface DaoEndereco {
	
	public void inserir(Endereco endereco);
	
	public void alterar(Endereco endereco);
	
	public void excluirPor(int id);
	
	public List<Endereco> listarPor(String logradouro);

	public List<Endereco> listarTodas();

}
