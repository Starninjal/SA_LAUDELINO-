package br.com.senai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Cidade;
import br.com.senai.core.domain.Frete;
import br.com.senai.core.service.CidadeService;
import br.com.senai.core.service.FreteService;


public class ViewCadastroCidade extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNome;
	private JTextField edtUF;
	private JButton btnSalvar;
	private FreteService service;
	private JComboBox<Frete> cbFrete;
	private Frete frete;
	private CidadeService serviceCidade;
	private Cidade cidade;
	private List<Frete> fretes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroCidade frame = new ViewCadastroCidade();
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
	public ViewCadastroCidade() {
		this.serviceCidade = new CidadeService();
		setTitle("Gerenciar Cidades - Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewListagemCidade view = new ViewListagemCidade();
				view.setVisible(true);
			}
		});
		btnConsultar.setBounds(285, 11, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("UF*");
		lblNewLabel.setBounds(311, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome*");
		lblNewLabel_1.setBounds(10, 33, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		edtNome = new JTextField();
		edtNome.setBounds(10, 64, 291, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		edtUF = new JTextField();
		edtUF.setColumns(10);
		edtUF.setBounds(311, 64, 46, 20);
		contentPane.add(edtUF);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nome = edtNome.getText();
				String uf = edtUF.getText();
				
				if(cidade == null) {
					cidade = new Cidade(nome, uf);
				}else {
					cidade.setNome(nome);
					cidade.setUf(uf);
				}
				
					serviceCidade.salvar(cidade);
					
					JOptionPane.showMessageDialog(contentPane, "Cidade salva com sucesso");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, e2.getMessage());
				}
			

			}
		});
		btnSalvar.setBounds(276, 140, 98, 26);
		contentPane.add(btnSalvar);

	
		
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
		this.edtNome.setText(cidade.getNome());
		this.edtUF.setText(cidade.getUf());
	}

	

}
