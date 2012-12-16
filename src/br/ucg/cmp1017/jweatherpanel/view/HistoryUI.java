package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JFrame;

/**
 * Classe respons�vel por representar o formul�rio respons�vel por pesquisar,
 * listar, atualizar e deletar registros de consultas ao webservice de
 * meteorologia.
 * 
 * @author Filipe Bezerra
 * 
 */
public class HistoryUI extends JFrame implements Serializable {

	/**
	 * ID de identifica��o da vers�o da classe para manter controle da evolu��o
	 * 
	 * @category Serializa��o de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 * @see {@link http
	 *      docs.oracle.com/javase/1.4.2/docs/api/java/io/Serializable.html}
	 * 
	 */
	private static final long serialVersionUID = 1180425288572095171L;

	/**
	 * Cria, inicializa e organiza o layout do formul�rio e seus componentes.
	 * 
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
	}
}
