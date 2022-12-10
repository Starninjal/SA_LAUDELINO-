package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Usuario;

public class UsuarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarios;		
		
	private final int QTDE_COLUNAS = 2;
			
	public UsuarioTableModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Login";
		}
			throw new IllegalArgumentException("Índíce inválido");
	
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return usuarios.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return usuarios.get(rowIndex).getLogin();
		}
			throw new IllegalArgumentException("Índíce inválido");
			
	}
	
	public Usuario getPor(int rowIndex) {
		return usuarios.get(rowIndex);
	}

	public void removerPor(int rowIndex) {
		this.usuarios.remove(rowIndex);
	}
}
