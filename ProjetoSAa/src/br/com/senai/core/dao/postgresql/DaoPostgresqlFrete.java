package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoFrete;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Cidade;
import br.com.senai.core.domain.Frete;

public class DaoPostgresqlFrete implements DaoFrete{
	
	private final String INSERT = "INSERT INTO fretes (nome, identificador, valor_km) values (?,?,?)";
	
	private final String UPDATE = "UPDATE fretes SET nome = ?, identificador = ?, valor_km = ? WHERE id = ?";
	
	private final String DELETE = "DELETE FROM fretes WHERE id = ?";
	
	private final String SELECT_BY_NOME = "select id, nome, identificador, valor_km from fretes where Upper(nome) LIKE Upper(?)";
	
	private final String SELECT_ALL = "SELECT id, nome, identificador, valor_km from fretes order by fretes.nome";
	
	private Connection conexao;
	
	public DaoPostgresqlFrete() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	@Override
	
	public void inserir(Frete frete) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, frete.getNome());
			ps.setString(2, frete.getIdentificador());
			ps.setDouble(3, frete.getValorDoQuilometro());
			ps.execute();
		} catch(Exception e) {
			throw new RuntimeException("Ocrreu um erro ao inserir a frete. Motivo:" + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}
	
	public void alterar(Frete frete) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutocommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, frete.getNome());
			ps.setString(2, frete.getIdentificador());
			ps.setDouble(3, frete.getValorDoQuilometro());
			ps.setInt(4, frete.getCodigo());
		} catch(Exception e) {
			
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
			if (isExclusaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutocommitDa(conexao, true);
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao excluir o Frete. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
	}

	@Override
	public List<Frete> listarPor(String nome) {
		// TODO Auto-generated method stub
		List<Frete> fretes = new ArrayList<Frete>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_NOME);
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while(rs.next()) {
				fretes.add(extrairDo(rs));
			}
			return fretes;
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar os contatos. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	private Frete extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String nomeCompleto = rs.getString("nome");
			String identificador = rs.getString("identificador");
			Double valorKm = rs.getDouble("valor_km");
			return new Frete(id, nomeCompleto, identificador, valorKm);
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao extrair o contato. Motivo: " + e.getMessage());
		}
	}
	
	public List<Frete >listarTodas() {
		List<Frete> fretes = new ArrayList<Frete>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				fretes.add(extrairDo(rs));
			}
			return fretes;
			
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar o frete. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	}

}
