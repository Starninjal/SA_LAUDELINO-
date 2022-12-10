package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoCidade;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Cidade;

public class DaoPostgresqlCidade implements DaoCidade {
	
	private final String INSERT = "INSERT INTO cidades (nome, uf) VALUES (?,?)";
	
	private final String UPDATE = "UPDATE cidades SET nome = ?, uf = ? WHERE id = ?";
	
	private final String DELETE = "DELETE FROM cidades WHERE id = ?";
	
	private final String SELECT_BY_NOME = "SELECT id, nome, uf from cidades where Upper(nome) LIKE Upper(?)";

	private final String SELECT_CIDADE = "SELECT id, nome, uf from cidades order by cidades.id";
	
	private Connection conexao;
	
	public DaoPostgresqlCidade() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	public void inserir(Cidade cidade) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, cidade.getNome());
			ps.setString(2, cidade.getUf());
			System.out.println(cidade.getNome());
			System.out.println(cidade.getUf());
			ps.execute();
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao inserir o contato. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public void alterar(Cidade cidade) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, cidade.getNome());
			ps.setString(2, cidade.getUf());
			ps.setInt(3, cidade.getCodigo());
			boolean isALteracaoOK = ps.executeUpdate() == 1;
			if (isALteracaoOK) {
				this.conexao.commit();	
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao alterar o contato. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public void excluirPor(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(DELETE);
			ps.setInt(1, id);
			boolean isExclusaoOK = ps.executeUpdate() == 1;
			if(isExclusaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao excluir o contato. Motivo: " + e.getMessage());
			
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public List<Cidade> listarPor(String nomeCompleto) {
		// TODO Auto-generated method stub
		List<Cidade> cidades = new ArrayList<Cidade>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_NOME);
			ps.setString(1, nomeCompleto);
			rs = ps.executeQuery();
			while(rs.next()) {
				cidades.add(extrairDo(rs));
			}
			return cidades;
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar os contatos. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	private Cidade extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String nomeCompleto = rs.getString("nome");
			String uf = rs.getString("uf");
			return new Cidade(id, nomeCompleto, uf);
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao extrair o contato. Motivo: " + e.getMessage());
			
		}
	}

	@Override
	public List<Cidade> listarTodas() {
		List<Cidade> cidades = new ArrayList<Cidade>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_CIDADE);
			rs = ps.executeQuery();
			while(rs.next()) {
				cidades.add(extrairDo(rs));
			}
			return cidades;
			
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar a cidade. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	}
	
	
}
