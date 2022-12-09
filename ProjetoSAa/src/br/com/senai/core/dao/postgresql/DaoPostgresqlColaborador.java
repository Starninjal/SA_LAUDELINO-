 package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoColaborador;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Colaborador;

public class DaoPostgresqlColaborador implements DaoColaborador {
	private final String SELECT_COLABORADOR = "SELECT id, nome_completo from colaboradores order by colaboradores.id";
	
	
	private Connection conexao;
	
	public DaoPostgresqlColaborador() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}
	
	private Colaborador extrairDo(ResultSet rs) {
		 try {
			 int id = rs.getInt("id");
			 String nomeCompleto = rs.getString("nome_completo");
			 return new Colaborador(id, nomeCompleto);
		 } catch(Exception e) {
			 throw new RuntimeException("Ocorreu um erro ao extrair o colaborador. Motivo: " + e.getMessage());
		 }
	}
	
	public List<Colaborador> listarTodas() {
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 ps = conexao.prepareStatement(SELECT_COLABORADOR);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 colaboradores.add(extrairDo(rs));
			 }
			 return colaboradores;
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao listar a cidade. Motivo: " + e.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
}
