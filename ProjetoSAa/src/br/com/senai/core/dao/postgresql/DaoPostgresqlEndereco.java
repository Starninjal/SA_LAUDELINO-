package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoEndereco;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Cidade;
import br.com.senai.core.domain.Endereco;

public class DaoPostgresqlEndereco implements DaoEndereco {

	private final String INSERT = "INSERT INTO enderecos (cep, logradouro, complemento, numero, id_cidade) values (?,?,?,?,?)";
	
	private final String UPDATE = "UPDATE enderecos SET cep = ?, logradouro = ?, complemento = ?, numero = ?, id_cidade = ? where id = ?";
	
	private final String DELETE = "DELETE FROM enderecos WHERE id = ?";
	
	private final String SELECT_BY_NOME = "SELECT e.id, e.cep, e.logradouro, "
					+ "e.complemento, e.numero, e.id_cidade, c.nome, c.uf "
					+ "FROM enderecos e, "
					+ "     cidades c "
					+ "WHERE e.id_cidade = c.id "
					+ "AND Upper(cep) LIKE Upper(?)";
	
	private final String SELECT_ENDERECO = "SELECT e.id, e.cep, e.logradouro, e.complemento, e.numero, "
			+ "e.id_cidade, c.nome, c.uf "
			+ "from enderecos e, cidades c"
			+ " WHERE e.id_cidade = c.id "
			+ "order by e.id";
	
	private Connection conexao;
	
	public DaoPostgresqlEndereco() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	
	
	@Override
	public void inserir(Endereco endereco) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareCall(INSERT);
			ps.setString(1, endereco.getCEP());
			ps.setString(2, endereco.getLogradouro());
			ps.setString(3, endereco.getComplemento());
			ps.setInt(4, endereco.getNumero());
			ps.setInt(5, endereco.getCidade().getCodigo());
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao inserir o contato. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}	

	@Override
	public void alterar(Endereco endereco) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			// pegamos o código da cidade com o get código e lá em baixo utilizamos a classe cidade.
			 ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			 ps = conexao.prepareStatement(UPDATE);
			 ps.setString(1, endereco.getCEP());
			 ps.setString(2, endereco.getLogradouro());
			 ps.setString(3, endereco.getComplemento());
			 ps.setInt(4, endereco.getNumero());
			 ps.setInt(5, endereco.getCidade().getCodigo());
			 ps.setInt(6, endereco.getCodigo());
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao alterar o endereco. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
 		
	}

	@Override
	public void excluirPor(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listarPor(String logradouro) {
		// TODO Auto-generated method stub
		List<Endereco> enderecos = new ArrayList<Endereco>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_NOME);
			ps.setString(1, logradouro);
			rs = ps.executeQuery();
			while(rs.next()) {
				enderecos.add(extrairDo(rs));
			}
			return enderecos;
		} catch(Exception e) {
			throw new IllegalArgumentException("Ocorreu um erro ao listar os endereços. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	
	}
	private Endereco extrairDo(ResultSet rs) {
		try {
			
			int id = rs.getInt("id");
			String cep = rs.getString("cep");
			String logradouro = rs.getString("logradouro");
			String complemento = rs.getString("complemento");
			int numero = rs.getInt("numero");
			
			int idCidade = rs.getInt("id_cidade");
			String nome = rs.getString("nome");
			String uf = rs.getString("uf");
			Cidade cidade = new Cidade(idCidade, nome, uf);
			
			return new Endereco(id, cep, logradouro, complemento, numero, cidade);
			
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao extrair o endereço. Motivo: " + e.getMessage());
		}
	}
	
	public List<Endereco>listarTodas() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_ENDERECO);
			rs = ps.executeQuery();
			while(rs.next()) {
				enderecos.add(extrairDo(rs));
			}
			return enderecos;
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar a endereço. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	
	}
}
