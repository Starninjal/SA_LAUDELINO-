package br.com.senai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Frete;
import br.com.senai.core.service.FreteService;
import br.com.senai.view.componentes.table.FreteTableModel;

public class ViewListagemFrete extends JFrame {

	private JPanel contentPane;
	
	private JTextField edtFiltro;
	
	private JTable tableFretes;
	
	private JScrollPane spTable;
	
	private FreteService service;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListagemFrete frame = new ViewListagemFrete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewListagemFrete() {
		this.service = new FreteService();
		setTitle("Gerenciar Fretes - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 895, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroFrete viewFrete = new ViewCadastroFrete();
				viewFrete.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(780, 11, 89, 26);
		contentPane.add(btnAdicionar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				List<Frete> fretes = service.listarPor(edtFiltro.getText());
				FreteTableModel model = new FreteTableModel(fretes);
				tableFretes.setModel(model);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
				}
		});
		btnListar.setBounds(780, 93, 89, 29);
		contentPane.add(btnListar);
		
		edtFiltro = new JTextField();
		edtFiltro.setColumns(10);
		edtFiltro.setBounds(10, 91, 748, 32);
		contentPane.add(edtFiltro);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableFretes.getSelectedRow();
				if (linhaSelecionada >= 0) {
					FreteTableModel model = (FreteTableModel) tableFretes.getModel();
					Frete freteSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroFrete view = new ViewCadastroFrete();
					view.setFrete(freteSelecionado);
					view.setVisible(true);
					dispose();
				}
			}
		});
		btnEditar.setBounds(649, 488, 89, 26);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableFretes.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int opcao = JOptionPane.showConfirmDialog(contentPane, "Deseja remover a linha selecionada?", "Remoção", JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						FreteTableModel model = (FreteTableModel)tableFretes.getModel();
						Frete freteSelecionado = model.getPor(linhaSelecionada);
						try {
							model.removerPor(linhaSelecionada);
							service.excluirPor(freteSelecionado.getCodigo());
							tableFretes.updateUI();
							JOptionPane.showMessageDialog(contentPane, "Frete removido com sucesso!");
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
						}
					}
				}
			}
		});
		btnRemover.setBounds(757, 488, 89, 26);
		contentPane.add(btnRemover);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setBounds(10, 67, 46, 14);
		contentPane.add(lblNewLabel);
		
		FreteTableModel model = new FreteTableModel(new ArrayList<Frete>());
		tableFretes = new JTable(model);
		spTable = new JScrollPane(tableFretes);
		spTable.setBounds(11, 161, 858, 285);
		contentPane.add(spTable);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(10, 136, 100, 14);
		contentPane.add(lblResultados);
	}

}
