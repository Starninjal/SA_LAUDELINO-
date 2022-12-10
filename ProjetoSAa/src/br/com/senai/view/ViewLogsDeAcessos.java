package br.com.senai.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewLogsDeAcessos extends JFrame {

	private JPanel contentPane;
	private JTable tableAcessos;

	/**
	 * Create the frame.
	 */
	public ViewLogsDeAcessos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox cbLogin = new JComboBox();
		cbLogin.setBounds(10, 36, 340, 22);
		contentPane.add(cbLogin);
		
		JScrollPane spTable = new JScrollPane();
		spTable.setBounds(10, 69, 340, 220);
		contentPane.add(spTable);
		
		tableAcessos = new JTable();
		spTable.setViewportView(tableAcessos);
	}
}
