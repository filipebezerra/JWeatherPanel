package br.ucg.cmp1017.jweatherpanel.view;

import javax.swing.JFrame;

public class WeatherDetailsUI extends JFrame {

	/**
	 * ID de identificação da versão da classe para manter controle da evolução
	 * 
	 * @category Serialização de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 */
	private static final long serialVersionUID = -6600698019494052891L;

	// private JPanel contentPane;

	/**
	 * Criar e organiza o layout do formulário.
	 */
	public WeatherDetailsUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(null);
		/*
		 * contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5,
		 * 5, 5, 5)); contentPane.setLayout(new BorderLayout(0, 0));
		 * setContentPane(contentPane);
		 */
	}

}
