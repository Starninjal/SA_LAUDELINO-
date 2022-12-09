package br.com.senai.view;

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
import br.com.senai.core.domain.Endereco;
import br.com.senai.core.service.EnderecoService;
import br.com.senai.view.componentes.table.EnderecoTableModel;

public class ViewListagemEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField edtFiltro;
	
	private EnderecoService service;
	
	private JTable tableEnderecos;
	
	private JScrollPane spTable;
	
	


	

	public ViewListagemEndereco() {
		this.service = new EnderecoService();
		setTitle("Gerenciar Endereço - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 876, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroEndereco viewEndereco = new ViewCadastroEndereco();
				viewEndereco.setVisible(true);
			}
		});
		btnAdicionar.setBounds(759, 12, 89, 26);
		contentPane.add(btnAdicionar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				List<Endereco> enderecos = service.listarPor(edtFiltro.getText());
				EnderecoTableModel model = new EnderecoTableModel(enderecos);
				tableEnderecos.setModel(model);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnListar.setBounds(759, 94, 89, 29);
		contentPane.add(btnListar);
		
		edtFiltro = new JTextField();
		edtFiltro.setColumns(10);
		edtFiltro.setBounds(12, 92, 735, 32);
		contentPane.add(edtFiltro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 162, 836, 224);
		contentPane.add(scrollPane);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(651, 489, 89, 26);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(759, 489, 89, 26);
		contentPane.add(btnRemover);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setBounds(12, 68, 46, 14);
		contentPane.add(lblNewLabel);
		
		EnderecoTableModel model = new EnderecoTableModel(new ArrayList<Endereco>());
		tableEnderecos = new JTable(model);
		spTable = new JScrollPane(tableEnderecos);
		spTable.setBounds(10, 128, 858, 187);
		contentPane.add(spTable);
		
		
		JLabel lblNewLabel_1 = new JLabel("Resultados");
		lblNewLabel_1.setBounds(12, 138, 75, 14);
		contentPane.add(lblNewLabel_1);
	}
}
