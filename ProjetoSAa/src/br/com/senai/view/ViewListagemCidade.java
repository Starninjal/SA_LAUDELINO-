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

import br.com.senai.core.domain.Cidade;
import br.com.senai.core.service.CidadeService;
import br.com.senai.view.componentes.table.CidadeTableModel;

public class ViewListagemCidade extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTable tableCidades;

	private JTextField edtFiltro;

	private JScrollPane spTable;
	
	private CidadeService service;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListagemCidade frame = new ViewListagemCidade();
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
	public ViewListagemCidade() {
		setResizable(false);
		this.service = new CidadeService();
		setTitle("Gerenciar Cidades  - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 894, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroCidade viewCadastro = new ViewCadastroCidade();
				viewCadastro.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(779, 11, 89, 40);
		contentPane.add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableCidades.getSelectedRow();
				if (linhaSelecionada >= 0) {
					CidadeTableModel model = (CidadeTableModel)tableCidades.getModel();
					Cidade cidadeSelecionada = model.getPor(linhaSelecionada);
					ViewCadastroCidade view = new ViewCadastroCidade();
					view.setCidade(cidadeSelecionada);
					view.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para editar");
				}
			}
		});
		btnEditar.setBounds(658, 474, 89, 40);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableCidades.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int opcao = JOptionPane.showConfirmDialog(contentPane, "Deseja remover a linha selecionada");
					if (opcao == 0) {
						CidadeTableModel model = (CidadeTableModel)tableCidades.getModel();
						Cidade cidadeSelecionada = model.getPor(linhaSelecionada);
						try {
							model.removerPor(linhaSelecionada);
							service.excluirPor(cidadeSelecionada.getCodigo());
							tableCidades.updateUI();
							JOptionPane.showMessageDialog(contentPane, "Cidade removida com sucesso!");
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
						}
				
					}
				}
			}
		});
		btnRemover.setBounds(766, 474, 89, 40);
		contentPane.add(btnRemover);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(10, 71, 46, 14);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(10, 91, 726, 32);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Cidade> cidades = service.listarPor(edtFiltro.getText());
					CidadeTableModel model = new CidadeTableModel(cidades);
					tableCidades.setModel(model);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(746, 91, 89, 29);
		contentPane.add(btnListar);
		
		CidadeTableModel model = new CidadeTableModel(new ArrayList<Cidade>());
		tableCidades = new JTable(model);
		spTable = new JScrollPane(tableCidades);
		spTable.setBounds(10, 128, 858, 187);
		contentPane.add(spTable);
		
		JLabel lblNewLabel = new JLabel("Resultados");
		lblNewLabel.setBounds(10, 135, 73, 16);
		contentPane.add(lblNewLabel);
		
		
	}
}
