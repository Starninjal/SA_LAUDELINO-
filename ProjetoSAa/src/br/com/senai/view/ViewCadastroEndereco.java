package br.com.senai.view;

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
import br.com.senai.core.domain.Endereco;
import br.com.senai.core.service.CidadeService;
import br.com.senai.core.service.EnderecoService;


public class ViewCadastroEndereco extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtCep;
	private JTextField edtLogradouro;
	private JTextField edtComplemento;
	private JTextField edtNumero;
	private CidadeService service;
	private Endereco endereco;
	private List<Cidade> cidades;	
	private Cidade cidade;
	private JComboBox<Cidade> cbCidade;
	private EnderecoService enderecoService;
	
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ViewCadastroEndereco() {
		this.service = new CidadeService();
		this.enderecoService = new EnderecoService();
		setTitle("Gerenciar Endereços - Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 879, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setBounds(23, 110, 46, 14);
		contentPane.add(lblNewLabel);
		
		edtCep = new JTextField();
		edtCep.setBounds(21, 130, 99, 29);
		contentPane.add(edtCep);
		edtCep.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Logradouro");
		lblNewLabel_1.setBounds(132, 110, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		edtLogradouro = new JTextField();
		edtLogradouro.setBounds(130, 130, 661, 29);
		contentPane.add(edtLogradouro);
		edtLogradouro.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Complemento");
		lblNewLabel_2.setBounds(23, 198, 85, 16);
		contentPane.add(lblNewLabel_2);
		
		edtComplemento = new JTextField();
		edtComplemento.setBounds(23, 225, 768, 29);
		contentPane.add(edtComplemento);
		edtComplemento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Número");
		lblNewLabel_3.setBounds(23, 300, 55, 16);
		contentPane.add(lblNewLabel_3);
		
		edtNumero = new JTextField();
		edtNumero.setBounds(23, 325, 389, 29);
		contentPane.add(edtNumero);
		edtNumero.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cidade");
		lblNewLabel_4.setBounds(423, 300, 55, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewListagemEndereco viewEndereco = new ViewListagemEndereco();
				viewEndereco.setVisible(true);
			}
		});
		btnConsultar.setBounds(731, 25, 98, 26);
		contentPane.add(btnConsultar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cep = edtCep.getText();
					String logradouro = edtLogradouro.getText();
					String complemento = edtComplemento.getText();
					int numero = Integer.parseInt(edtNumero.getText());
					Cidade cidade = (Cidade) cbCidade.getSelectedItem();					
					
					if (endereco == null) {
						endereco = new Endereco(cep, logradouro, complemento, numero, cidade);
					} else {
						endereco.setCEP(cep);
						endereco.setLogradouro(logradouro);
						endereco.setComplemento(complemento);
						endereco.setNumero(numero);
						endereco.setCidade(cidade);
					}
					JOptionPane.showMessageDialog(contentPane, "Endereço salvo com sucesso!");
					enderecoService.salvar(endereco);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnSalvar.setBounds(731, 479, 98, 26);
		contentPane.add(btnSalvar);
		
		cbCidade = new JComboBox<>();

		cbCidade.setBounds(422, 326, 328, 26);
		contentPane.add(cbCidade);
		
		this.carregarCombo();
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
		this.edtCep.setText(endereco.getCEP());
		this.edtLogradouro.setText(endereco.getLogradouro());
		this.edtComplemento.setText(endereco.getComplemento());
		this.edtNumero.setText(String.valueOf(endereco.getNumero()));
		
	}
	
	private void carregarCombo() {
		List<Cidade> cidades = service.listarTodas();
		for (Cidade cidade : cidades) {
			cbCidade.addItem(cidade);
		}
	}
	
	
	
	
}
