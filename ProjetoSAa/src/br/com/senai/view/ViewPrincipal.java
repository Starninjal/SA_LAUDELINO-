package br.com.senai.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setOpacity(1.0f);
		setResizable(false);
		setTitle("ERP SENAI - Módulo de Gestão de Logística");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 570);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JMenuBar barraPrincipal = new JMenuBar();
		barraPrincipal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		barraPrincipal.setBounds(0,0,940,22);
		contentPane.add(barraPrincipal);
		
		JMenu menuCadastro = new JMenu("Cadastros");
		menuCadastro.setBackground(Color.GREEN);
		menuCadastro.setFont(new Font("Dialog", Font.BOLD, 12));
		barraPrincipal.add(menuCadastro);
		
		JMenuItem subMenuCidade = new JMenuItem("Cidade");
		subMenuCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewListagemCidade view = new ViewListagemCidade();
				view.setVisible(true);
			}
		});
		menuCadastro.add(subMenuCidade);
		
		JMenuItem subMenuEnderecos = new JMenuItem("Endereços");
		subMenuEnderecos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewListagemEndereco viewEndereco = new ViewListagemEndereco();
				viewEndereco.setVisible(true);

			}
		});
		menuCadastro.add(subMenuEnderecos);
		
		JMenuItem subMenuFretes = new JMenuItem("Fretes");
		subMenuFretes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewListagemFrete viewFrete = new ViewListagemFrete();
				viewFrete.setVisible(true);
				dispose();
				

			}
		});
		menuCadastro.add(subMenuFretes);



		
		JMenu menuLogistica = new JMenu("Logística");
		barraPrincipal.add(menuLogistica);
		
		
		JMenuItem subMenuEntregas = new JMenuItem("Entregas");
		subMenuEntregas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEntrega view = new ViewEntrega();
				view.setVisible(true);
			}
		});
		menuLogistica.add(subMenuEntregas);
		
		JMenu opcaoSair = new JMenu("Sair");
		
		opcaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		barraPrincipal.add(opcaoSair);
		
		
		

		
	}

}
