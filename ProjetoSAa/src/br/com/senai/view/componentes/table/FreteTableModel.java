package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Frete;

public class FreteTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 4;
	
	private List<Frete> fretes;
	
	public FreteTableModel(List<Frete> fretes) {
		this.fretes = fretes;
	}
	
	public int getRowCount() {
		return fretes.size();
	}
	
	public String getColumnName(int column) {
		if ( column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Nome";
		} else if (column == 2) {
			return "Identificador";
		} else if(column == 3) {
			return "valor do quilometro";
		}
			throw new IllegalArgumentException("Índice inválido");
	}
	
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return fretes.get(rowIndex).getCodigo();
		} else if(columnIndex == 1) {
			return fretes.get(rowIndex).getNome();
		} else if(columnIndex == 2) {
			return fretes.get(rowIndex).getIdentificador();
		} else if(columnIndex == 3) {
			return fretes.get(rowIndex).getValorDoQuilometro();
		} 
			throw new IllegalArgumentException("Índice inválido!");
	}
	
	public Frete getPor(int rowIndex) {
		return fretes.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.fretes.remove(rowIndex);
	}
}
