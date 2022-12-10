package br.com.senai.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Usuario;

public class ViewCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField edtLogin;
	private JTextField edtSenha;
	private JLabel lblConfirmacaoDeSenha;
	private JTextField edtConfirmacaoDeSenha;
	private Usuario usuario;
	private JButton btnConsultar;




	/**
	 * Create the frame.
	 */
	public ViewCadastroUsuario() {
		setTitle("Gerenciar Usuários - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login*");
		lblLogin.setBounds(10, 40, 46, 14);
		contentPane.add(lblLogin);
		
		edtLogin = new JTextField();
		edtLogin.setBounds(10, 65, 359, 20);
		contentPane.add(edtLogin);
		edtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha*");
		lblSenha.setBounds(10, 96, 46, 14);
		contentPane.add(lblSenha);
		
		edtSenha = new JTextField();
		edtSenha.setBounds(10, 124, 359, 20);
		contentPane.add(edtSenha);
		edtSenha.setColumns(10);
		
		lblConfirmacaoDeSenha = new JLabel("Confirmação de Senha");
		lblConfirmacaoDeSenha.setBounds(10, 155, 168, 14);
		contentPane.add(lblConfirmacaoDeSenha);
		
		edtConfirmacaoDeSenha = new JTextField();
		edtConfirmacaoDeSenha.setBounds(10, 180, 359, 20);
		contentPane.add(edtConfirmacaoDeSenha);
		edtConfirmacaoDeSenha.setColumns(10);
		
		JCheckBox chkAtivo = new JCheckBox("Ativo");
		chkAtivo.setBounds(10, 207, 97, 23);
		contentPane.add(chkAtivo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(280, 211, 89, 23);
		contentPane.add(btnSalvar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(280, 11, 89, 23);
		contentPane.add(btnConsultar);
		
		
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.edtLogin.setText(usuario.getLogin());
		this.edtSenha.setText(usuario.getSenha());
		
		
	}
}
