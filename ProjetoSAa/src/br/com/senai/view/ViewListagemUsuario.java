package br.com.senai.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Usuario;
import br.com.senai.view.componentes.table.UsuarioTableModel;

public class ViewListagemUsuario extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtFiltro;
	private JScrollPane spTable;
	private JTable tableUsuarios;

	/**
	 * Create the frame.
	 */
	public ViewListagemUsuario() {
		setTitle("Gerenciar Usuários - Listagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(335, 11, 89, 23);
		contentPane.add(btnAdicionar);
		
		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setBounds(10, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(10, 70, 315, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(335, 69, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableUsuarios.getSelectedRow();
				if (linhaSelecionada >= 0) {
					UsuarioTableModel model = (UsuarioTableModel) tableUsuarios.getModel();
					Usuario usuarioSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroUsuario view = new ViewCadastroUsuario();
					view.setUsuario(usuarioSelecionado);
					view.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para editar!");
				}
			}});
		btnEditar.setBounds(335, 218, 89, 23);
		contentPane.add(btnEditar);
		
		UsuarioTableModel model = new UsuarioTableModel(new ArrayList<Usuario>());
		tableUsuarios = new JTable(model);
		spTable = new JScrollPane(tableUsuarios);
		spTable.setMaximumSize(new Dimension(30728, 32767));
		spTable.setBounds(10, 101, 414, 106);
		contentPane.add(spTable);
		
	}
}
