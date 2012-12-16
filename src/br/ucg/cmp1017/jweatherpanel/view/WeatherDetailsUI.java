package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JFrame;

/**
 * Classe responsável por representar o formulário responsável por detalhar os
 * registros de consultas ao webservice de meteorologia.
 * 
 * @author Filipe Bezerra
 * 
 */
public class WeatherDetailsUI extends JFrame implements Serializable {

	/**
	 * ID de identificação da versão da classe para manter controle da evolução
	 * 
	 * @category Serialização de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 * @see {@link http
	 *      docs.oracle.com/javase/1.4.2/docs/api/java/io/Serializable.html}
	 * 
	 */
	private static final long serialVersionUID = -6600698019494052891L;

	/**
	 * Cria, inicializa e organiza o layout do formulário e seus componentes.
	 * 
	 */
	public WeatherDetailsUI() {
		setName("frameDetailsUI");
		setTitle("JWeatherPanel - Detalhes da Consulta");
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(800, 600));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
	}
}
