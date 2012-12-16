package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

/**
 * Classe respons�vel por representar o formul�rio respons�vel por pesquisar,
 * lista, atualizar e deletar registros de consultas ao webservice de
 * meteorologia.
 * 
 * @author Filipe Bezerra
 * 
 */
public class HistoryUI extends JFrame {

	/**
	 * ID de identifica��o da vers�o da classe para manter controle da evolu��o
	 * 
	 * @category Serializa��o de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 */
	private static final long serialVersionUID = 1180425288572095171L;

	// private JPanel contentPane;

	/**
	 * Criar e organiza o layout do formul�rio.
	 */
	public HistoryUI() {
		setName("frameHistoryUI");
		setTitle("JWeatherPanel - Hist�rico Din�mico");
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(800, 600));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		/*
		 * contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5,
		 * 5, 5, 5)); contentPane.setLayout(new BorderLayout(0, 0));
		 * setContentPane(contentPane);
		 */
	}
}
