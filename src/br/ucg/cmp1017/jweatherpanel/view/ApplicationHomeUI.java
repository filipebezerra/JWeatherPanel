package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Classe responsável por ser o ponto de entrada da aplicação e executar o
 * formulário principal da aplicação.
 * 
 * @author Filipe Bezerra
 * 
 */
public class ApplicationHomeUI extends JFrame {

	/**
	 * ID de identificação da versão da classe para manter controle da evolução
	 * 
	 * @category Serialização de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 */
	private static final long serialVersionUID = 4395743645388772923L;
	private JTextField txtFieldListCountries;
	private JComboBox<String> cmbBoxListCities;
	private JButton btnSearchCities;
	private JButton btnSearchWearther;

	// private JPanel contentPane;

	/**
	 * Inicializa e executa o bloco da aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
	 * Criar e organiza o layout do formulário principal.
	 */
	public ApplicationHomeUI() {
		setName("frameHomeUI");
		setTitle("JWeatherPanel - Home");
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 447);
		getContentPane().setLayout(null);

		txtFieldListCountries = new JTextField();
		txtFieldListCountries.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtFieldListCountries.setBounds(134, 69, 247, 25);
		getContentPane().add(txtFieldListCountries);
		txtFieldListCountries.setColumns(10);

		cmbBoxListCities = new JComboBox<String>();
		cmbBoxListCities.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbBoxListCities.setFont(new Font("Verdana", Font.PLAIN, 14));
		cmbBoxListCities.setBounds(134, 115, 247, 25);
		getContentPane().add(cmbBoxListCities);

		btnSearchCities = new JButton("Search Cities...");
		btnSearchCities.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchCities.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSearchCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchCities.setBounds(391, 69, 161, 25);
		getContentPane().add(btnSearchCities);

		btnSearchWearther = new JButton("Search Weather...");
		btnSearchWearther.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchWearther.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSearchWearther.setBounds(391, 115, 161, 25);
		getContentPane().add(btnSearchWearther);
		/*
		 * contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5,
		 * 5, 5, 5)); contentPane.setLayout(new BorderLayout(0, 0));
		 * setContentPane(contentPane);
		 */}
}
