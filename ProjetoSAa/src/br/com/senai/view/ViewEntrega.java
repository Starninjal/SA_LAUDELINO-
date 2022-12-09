package br.com.senai.view;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senai.core.domain.Colaborador;
import br.com.senai.core.domain.Endereco;
import br.com.senai.core.domain.Frete;
import br.com.senai.core.service.ColaboradorService;
import br.com.senai.core.service.EnderecoService;
import br.com.senai.core.service.FreteService;

public class ViewEntrega extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Frete> cbFrete;
	private FreteService freteService;
	private EnderecoService enderecoService;
	private JComboBox<Endereco> cbEndereco;
	private JComboBox<Colaborador> cbColaborador;
	private ColaboradorService colaboradorService;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewEntrega() {
		this.colaboradorService = new ColaboradorService();
		this.freteService = new FreteService();
		this.enderecoService = new EnderecoService();
		setTitle("Gerenciar Entregas - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFrete = new JLabel("Frete");
		lblFrete.setBounds(10, 48, 46, 14);
		contentPane.add(lblFrete);
		

		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 132, 94, 14);
		contentPane.add(lblEndereco);
		
		
		JLabel lblColaborador = new JLabel("Colaborador");
		lblColaborador.setBounds(429, 48, 94, 14);
		contentPane.add(lblColaborador);
		
		
		
		JLabel lblDataDeSaida = new JLabel("Data De Saída");
		lblDataDeSaida.setBounds(10, 203, 94, 14);
		contentPane.add(lblDataDeSaida);
		
		JLabel lblHoraDaSaida = new JLabel("Hora da Saída");
		lblHoraDaSaida.setBounds(200, 203, 100, 14);
		contentPane.add(lblHoraDaSaida);
		
		JFormattedTextField ftfHoraDeSaida = new JFormattedTextField();
		ftfHoraDeSaida.setBounds(200, 228, 129, 29);
		contentPane.add(ftfHoraDeSaida);
		
		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			mascara.install(ftfHoraDeSaida);
		} catch(Exception e) {
			
		}
		
		JLabel lblDataDeChegada = new JLabel("Data de Chegada");
		lblDataDeChegada.setBounds(357, 203, 107, 14);
		contentPane.add(lblDataDeChegada);
		
		JFormattedTextField ftfDataDeChegada = new JFormattedTextField();
		ftfDataDeChegada.setBounds(357, 228, 138, 29);
		contentPane.add(ftfDataDeChegada);
		
		JLabel lblHoraDeChegada = new JLabel("Hora de Chegada"); 
		lblHoraDeChegada.setBounds(547, 203, 113, 14);
		contentPane.add(lblHoraDeChegada);
		
		JFormattedTextField ftfHoraDeChegada = new JFormattedTextField();
		ftfHoraDeChegada.setBounds(545, 228, 275, 29);
		contentPane.add(ftfHoraDeChegada);
		
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.install(ftfHoraDeChegada);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblKmPercorrido = new JLabel("Km Percorrido");
		lblKmPercorrido.setBounds(10, 281, 113, 14);
		contentPane.add(lblKmPercorrido);
		
		textField = new JTextField();
		textField.setBounds(10, 312, 138, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total(R$)");
		lblValorTotal.setBounds(176, 281, 94, 14);
		contentPane.add(lblValorTotal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 312, 138, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblObservacoes = new JLabel("Observações");
		lblObservacoes.setBounds(10, 374, 113, 16);
		contentPane.add(lblObservacoes);
		
		JList list = new JList();
		list.setBounds(10, 417, 835, 124);
		contentPane.add(list);
		
		cbFrete = new JComboBox<>();
		
		cbFrete.setBounds(10, 73, 396, 29);
		contentPane.add(cbFrete);
		this.carregarComboFrete();
		
		cbEndereco = new JComboBox<>();
		
		cbEndereco.setBounds(10, 163, 835, 29);
		contentPane.add(cbEndereco);
		this.carregarComboEndereco();
		
		cbColaborador = new JComboBox<>();
		cbColaborador.setBounds(429, 73, 416, 29);
		contentPane.add(cbColaborador);
		
		JFormattedTextField ftfDataDeSaida = new JFormattedTextField();
		ftfDataDeSaida.setBounds(10, 228, 138, 29);
		contentPane.add(ftfDataDeSaida);
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
				mascara.install(ftfDataDeSaida);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.carregarComboColaborador();
	}
	
	private void carregarComboFrete() {
		List<Frete> fretes = freteService.listarTodas();
		for (Frete frete: fretes) {
			cbFrete.addItem(frete);
		}
	}
	
	private void carregarComboEndereco() {
		List<Endereco> enderecos = enderecoService.listarTodas();
		for (Endereco endereco : enderecos) {
			cbEndereco.addItem(endereco);
		}
	}
	
	private void carregarComboColaborador() {
		List<Colaborador> colaboradores = colaboradorService.listarTodas();
		for (Colaborador colaborador : colaboradores) {
			cbColaborador.addItem(colaborador);
		}
	}
}