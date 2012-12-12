package br.ucg.cmp1017.jweatherpanel.view;

import javax.swing.JFrame;

/**
 * Classe responsável por representar o formulário responsável por pesquisar,
 * lista, atualizar e deletar registros de consultas ao webservice de
 * meteorologia.
 * 
 * @author Filipe Bezerra
 * 
 */
public class HistoryUI extends JFrame {

	/**
	 * ID de identificação da versão da classe para manter controle da evolução
	 * 
	 * @category Serialização de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 */
	private static final long serialVersionUID = 1180425288572095171L;

	// private JPanel contentPane;

	/**
	 * Criar e organiza o layout do formulário.
	 */
	public HistoryUI() {
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
