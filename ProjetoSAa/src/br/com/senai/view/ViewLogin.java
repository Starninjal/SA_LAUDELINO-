package br.com.senai.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField edtUsuario;
	private JTextField edtSenha;

	/**
	 * Create the frame.
	 */
	public ViewLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		edtUsuario = new JTextField();
		edtUsuario.setBounds(10, 36, 248, 20);
		contentPane.add(edtUsuario);
		edtUsuario.setColumns(10);
		
		edtSenha = new JTextField();
		edtSenha.setColumns(10);
		edtSenha.setBounds(10, 92, 248, 20);
		contentPane.add(edtSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogar.setBounds(93, 123, 89, 23);
		contentPane.add(btnLogar);
	}

}
