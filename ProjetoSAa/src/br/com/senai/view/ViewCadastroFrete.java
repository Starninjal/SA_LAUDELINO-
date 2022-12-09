package br.com.senai.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Frete;
import br.com.senai.core.service.FreteService;

public class ViewCadastroFrete extends JFrame {

	private JPanel contentPane;
	private JTextField edtNome;
	private JTextField edtIdentificador;
	private JTextField edtValor;
	private Frete frete;
	private FreteService service;
	private JComboBox<Frete> cbFrete;
	// private EntregaService entregaService; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroFrete frame = new ViewCadastroFrete();
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
	public ViewCadastroFrete() {
		this.service = new FreteService();
		// this.entregaService = new EntregaService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 67, 46, 14);
		contentPane.add(lblNome);
		
		edtNome = new JTextField();
		edtNome.setBounds(10, 89, 393, 20);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(10, 141, 117, 14);
		contentPane.add(lblIdentificador);
		
		edtIdentificador = new JTextField();
		edtIdentificador.setBounds(10, 168, 228, 20);
		contentPane.add(edtIdentificador);
		edtIdentificador.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Valor (R$)");
		lblNewLabel.setBounds(244, 141, 78, 14);
		contentPane.add(lblNewLabel);
		
		edtValor = new JTextField();
		edtValor.setBounds(244, 168, 159, 20);
		contentPane.add(edtValor);
		edtValor.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewListagemFrete viewFrete = new ViewListagemFrete();
				viewFrete.setVisible(true);
			}
		});
		btnConsultar.setBounds(326, 11, 98, 26);
		contentPane.add(btnConsultar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = edtNome.getText();
				String identificador = edtIdentificador.getText();
				Double valor = Double.parseDouble(edtValor.getText());
				
				if (frete == null) {
					frete = new Frete(nome, identificador, valor);
				}else {
					frete.setNome(nome);
					frete.setIdentificador(identificador);
					frete.setValorDoQuilometro(valor);
				}

				try {
					service.salvar(frete);
					JOptionPane.showMessageDialog(contentPane, "Frete salvo com sucesso");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}				
				
			}
		});
		btnSalvar.setBounds(326, 224, 98, 26);
		contentPane.add(btnSalvar);
		
		JComboBox cbFrete = new JComboBox();
		cbFrete.setBounds(28, 226, 78, 22);
		contentPane.add(cbFrete);
		
	}
	
	public void setFrete(Frete frete) {
		this.frete = frete;
		this.edtNome.setText(frete.getNome());
		this.edtIdentificador.setText(frete.getIdentificador());
		this.edtValor.setText(String.valueOf(frete.getValorDoQuilometro()));
	}
}
