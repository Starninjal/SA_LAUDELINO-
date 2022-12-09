package br.com.senai.core.service;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.senai.core.dao.DaoCidade;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Cidade;

public class CidadeService {
	
private DaoCidade dao;
	
	public CidadeService() {
		this.dao = FactoryDao.getInstance().getDaoCidade();
	}
	
	public void salvar(Cidade cidade) {
		this.validar(cidade);
		if(cidade.isJaPersistido()) {
			this.dao.alterar(cidade);
		}else {
			this.dao.inserir(cidade);
		}
		
	}
	
	public void validar(Cidade cidade) {
		if(cidade != null) {
		  boolean isNomeInvalido = cidade.getNome().length() < 3
		  || cidade.getNome().length() > 100;
		  if(isNomeInvalido) {
			  throw new IllegalArgumentException("O nome é obrigatório e precisa"
			  + "conter de 3 a 100 caracteres");
		  }
		  
		  boolean isUfInvalida = cidade.getUf() == null
				  || cidade.getUf().isBlank()
				  || cidade.getUf().length() < 2
				  || cidade.getUf().length() > 2;
				  
				  if(isUfInvalida) {
					  throw new IllegalArgumentException("A UF é obrigatória e precisa conter dois caracteres");
				  }
		}else {
			JOptionPane.showMessageDialog(null, "A cidade é obrigatória");
		}
	}
	
	public List<Cidade> listarPor(String nome) {
		if (nome != null && !nome.isBlank()) {
			String filtro = "%" + nome + "%";
			return  dao.listarPor(filtro);
		} else {
			throw new IllegalArgumentException("O filtro para listagem é obrigatório");
		}
	}
	
	public void excluirPor(int idDaCidade) {
		if(idDaCidade > 0) {
			this.dao.excluirPor(idDaCidade);
		}else {
			throw new IllegalArgumentException("O id da cidade não "
					+ "pode ser menor do que 1");
		}

    }
	
	public List<Cidade> listarTodas() {
		return dao.listarTodas();
	}
}
	
	
	

