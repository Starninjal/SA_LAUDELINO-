package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Cidade;

public class CidadeTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 3;
	
	private List<Cidade> cidades;	
	
	public CidadeTableModel(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	@Override
	public int getRowCount() {

		return cidades.size();
		
	}

	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Nome";
		} else if (column == 2 ) {
			return "UF";
		}
			throw new IllegalArgumentException("Índice inválido");
	}
	
	@Override
	public int getColumnCount() {

		return QTDE_COLUNAS;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return cidades.get(rowIndex).getCodigo();
		} else if (columnIndex == 1) {
			return cidades.get(rowIndex).getNome();
		} else if (columnIndex == 2) {
			return cidades.get(rowIndex).getUf();
		}
			throw new IllegalArgumentException("Índice inválido");

	}
	
	public Cidade getPor(int rowIndex) {
		return cidades.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.cidades.remove(rowIndex);
	}
	
}
