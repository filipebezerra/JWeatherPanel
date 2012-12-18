package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Classe respons�vel por ser o ponto de entrada da aplica��o e executar o
 * formul�rio principal da aplica��o.
 * 
 * @author Filipe Bezerra
 * 
 */
public class ApplicationHomeUI extends JFrame implements Serializable {

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
	private static final long serialVersionUID = 4395743645388772923L;
	/**
	 * Campo de entrada de um nome de pa�s para pesquisa de cidades dispon�veis
	 * para obter informa��es de clima
	 */
	private final JTextField txtFieldListCountries;
	/**
	 * Campo de sa�da com lista de cidades dispon�veis para obter informa��es de
	 * clima
	 */
	private JComboBox<String> cmbBoxListCities;
	/**
	 * Bot�o que executa a consulta de cidades levando em conta o pa�s informado
	 */
	private final JButton btnSearchCities;
	/**
	 * Bot�o que executa a consulta de clima levando em conta o pa�s e a cidade
	 * informados
	 */
	private final JButton btnConsultWearther;

	/**
	 * Define uma apar�ncia e comportamento para a interface swing utilizando
	 * L&F padr�o da JRE e inicializa e executa a aplica��o.
	 * 
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				try {
					ApplicationHomeUI frame = new ApplicationHomeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria, inicializa, adiciona eventos e organiza o layout do formul�rio e
	 * seus componentes.
	 * 
	 */
	public ApplicationHomeUI() {
		setName("frameHomeUI");
		setTitle("JWeatherPanel - Home");
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		txtFieldListCountries = new JTextField();
		txtFieldListCountries.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtFieldListCountries.setBounds(134, 69, 479, 25);
		getContentPane().add(txtFieldListCountries);
		txtFieldListCountries.setColumns(10);

		cmbBoxListCities = new JComboBox<String>();
		cmbBoxListCities.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbBoxListCities.setFont(new Font("Verdana", Font.PLAIN, 14));
		cmbBoxListCities.setBounds(134, 115, 479, 25);
		getContentPane().add(cmbBoxListCities);

		btnSearchCities = new JButton("Search Cities");
		btnSearchCities.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchCities.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSearchCities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
			}
		});
		btnSearchCities.setBounds(623, 69, 161, 25);
		getContentPane().add(btnSearchCities);

		btnConsultWearther = new JButton("Consult Weather");
		btnConsultWearther.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultWearther.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnConsultWearther.setBounds(623, 115, 161, 25);
		getContentPane().add(btnConsultWearther);

		JLabel lblLinkConsultHistory = new JLabel("Go to Consult History >>");
		lblLinkConsultHistory.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkConsultHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(final MouseEvent e) {
				JLabel instanceJLabel = (JLabel) e.getSource();
				instanceJLabel.setText("<html><u>" + instanceJLabel.getText()
						+ "</u>");
			}

			@Override
			public void mouseExited(final MouseEvent e) {
				JLabel instanceJLabel = (JLabel) e.getSource();
				instanceJLabel.setFont(new Font(instanceJLabel.getFont()
						.getName(), 0, instanceJLabel.getFont().getSize()));
				instanceJLabel.setText(instanceJLabel.getText()
						.replace("<html>", "").replace("<u>", "")
						.replace("</u>", ""));
			}

			@Override
			public void mouseClicked(final MouseEvent e) {
				new WeatherHistoryUI().setVisible(true);
			}
		});

		lblLinkConsultHistory.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLinkConsultHistory.setBounds(595, 541, 189, 20);
		getContentPane().add(lblLinkConsultHistory);
	}

	/**
	 * Obter campo que armazena o argumento de pesquisa pela lista de pa�ses
	 * dispon�veis para obter informa��es do clima
	 * 
	 * @return Campo com texto para pesquisa de pa�ses e todos seus atributos
	 * 
	 */
	public JTextField getTxtFieldListCountries() {
		return txtFieldListCountries;
	}

	/**
	 * Obter campo que armazena a lista de cidades dispon�veis para obter
	 * informa��es do clima
	 * 
	 * @return Campo com lista de cidades e todos seus atributos
	 */
	public JComboBox<String> getCmbBoxListCities() {
		return cmbBoxListCities;
	}

	/**
	 * Alterar a lista de cidades dispon�veis para obter informa��es de clima
	 * 
	 * @param cmbBoxListCities
	 *            Lista de nomes de cidades
	 */
	public void setCmbBoxListCities(final JComboBox<String> cmbBoxListCities) {
		this.cmbBoxListCities = cmbBoxListCities;
	}
}
