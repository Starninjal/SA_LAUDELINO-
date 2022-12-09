package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Endereco;

public class EnderecoTableModel extends AbstractTableModel {	
	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 5;
	
	private List<Endereco> enderecos;
	
	public EnderecoTableModel(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1 ) {
			return "CEP";
		} else if (column == 2) {
			return "Logradouro";
		} else if (column == 3) {
			return "Complemento";
		} else if (column == 4) {
			return "Número";
		} else if (column == 5) {
			return "Id_Cidade";
		}
		throw new IllegalArgumentException("Índice inválido");
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return enderecos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return QTDE_COLUNAS;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 0 ) {
			return enderecos.get(rowIndex).getCodigo();
		} else if(columnIndex == 1) {
			return enderecos.get(rowIndex).getCEP();
		} else if (columnIndex == 2) {
			return enderecos.get(rowIndex).getLogradouro();
		} else if (columnIndex == 3) {
			return enderecos.get(rowIndex).getComplemento();
		} else if (columnIndex == 4) { 
			return enderecos.get(rowIndex).getNumero();
		} else if (columnIndex == 5) {
			return enderecos.get(rowIndex).getCidade().getCodigo();
		}
			throw new IllegalArgumentException("Índice inválido!");
	}	
	
	public Endereco getpor(int rowIndex) {
		return enderecos.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.enderecos.remove(rowIndex);
	}
	
	
}
