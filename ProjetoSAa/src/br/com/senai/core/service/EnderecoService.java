package br.com.senai.core.service;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.senai.core.dao.DaoEndereco;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Cidade;
import br.com.senai.core.domain.Endereco;


public class EnderecoService {
	
	private DaoEndereco dao;
	
	public EnderecoService() {
		this.dao = FactoryDao.getInstance().getDaoEndereco();
	}
	
	public void salvar(Endereco endereco) {
		this.validar(endereco);
		if(endereco.isJaPersistido()) {
			this.dao.alterar(endereco);
		} else {
			this.dao.inserir(endereco);
		}
	}
	
	public void validar(Endereco endereco) {
		if(endereco != null) {
			boolean isCEPInvalido = endereco.getCEP() == null || endereco.getCEP().isBlank()
					|| endereco.getCEP().length() != 9;

			if (isCEPInvalido) {
				throw new IllegalArgumentException("O CEP é obrigatório e deve possuir nove caracteres");
			}

			boolean isLogradouroInvalido = endereco.getLogradouro() == null || endereco.getLogradouro().isBlank()
					|| endereco.getLogradouro().length() > 500;

			if (isLogradouroInvalido) {
				throw new IllegalArgumentException("O logradouro é obrigatório");
			}

			boolean isComplementoInvalido = endereco.getComplemento().isBlank()
					|| endereco.getComplemento().length() > 2000;

			if (isComplementoInvalido) {
				throw new IllegalArgumentException(
						"O complemento não pode conter espaço em branco" + " e deve conter até 2000 caracteres");
			}

			boolean isNumeroInvalido = endereco.getNumero() < 0;

			if (isNumeroInvalido) {
				throw new IllegalArgumentException("O número não pode ser negativo");
			}
		}else {
			JOptionPane.showMessageDialog(null, "O endereço é obrigatório");
		}
		 	
	}

	
	public List<Endereco> listarPor(String CEP) {
		if (CEP != null && !CEP.isBlank()) {
			String filtro = "%" + CEP + "%";
			return  dao.listarPor(filtro);
		} else {
			throw new IllegalArgumentException("O filtro para listagem é obrigatório");
		}
	}
	
	public void excluirPor(int id) {
		if(id > 0) {
			this.dao.excluirPor(id);
		} else {
			JOptionPane.showMessageDialog(null, "O id do endereço não pode"
					+ " ser menor do que 1");
		}

	}
	
	public List<Endereco> listarTodas() {
		return dao.listarTodas();
	}
	
	
}
