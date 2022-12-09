package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoFrete;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Cidade;
import br.com.senai.core.domain.Frete;

public class FreteService {
	
private DaoFrete dao;
	
	public FreteService() {
		this.dao = FactoryDao.getInstance().getDaoFrete();
	}
	
	public void salvar(Frete frete) {		
		this.validar(frete);
		if(frete.isJaPersistido()) {
			this.dao.alterar(frete);
		}else {
			this.dao.inserir(frete);
		}
		
	}
	
	public void validar(Frete frete){
		if(frete != null) {
			boolean isNomeInvalido = frete.getNome() == null
			|| frete.getNome().isBlank()
			|| frete.getNome().length() < 2 
			|| frete.getNome().length() > 150;
			
			if(isNomeInvalido){
				throw new IllegalArgumentException("O nome é obrigatório e precisa"
				 + "conter de 2 a 150 caracteres");
			}
			
			boolean isIdentificadorInvalido = frete.getIdentificador() == null
			|| frete.getIdentificador().isBlank()
			|| frete.getIdentificador().length() < 3 
			|| frete.getIdentificador().length() > 10;
			
			if(isIdentificadorInvalido) {
				throw new IllegalArgumentException("O identificador é obrigatório e"
				 +"precisa conter de 3 a 10 caracteres");
			}
			
			boolean isValorQuilometroInvalido = frete.getValorDoQuilometro() <= 0;
			
			if(isValorQuilometroInvalido) {
				throw new IllegalArgumentException("O valor da quilometragem não pode ser"
				+ "menor ou igual a zero");
			}
			
		} else {
			throw new IllegalArgumentException("O frete não pode ser nulo");
		}
		
		
		
		
	}
	
	public void excluirPor(int idDoFrete) {
		if(idDoFrete > 0) {
			this.dao.excluirPor(idDoFrete);
		}else {
			throw new IllegalArgumentException("O id do frete não pode"
			+ "ser menor do que 1");
		}
	}
	
	
	
	public List<Frete> listarPor(String nome) {
		if(nome != null && !nome.isBlank()) {
			String filtro = "%" + nome + "%";
			return dao.listarPor(filtro);
		}else {
			throw new IllegalArgumentException("O filtro é obrigatório para listagem");
		}
		
	}
	
	public List<Frete> listarTodas() {
		return dao.listarTodas();
	}
	
}
