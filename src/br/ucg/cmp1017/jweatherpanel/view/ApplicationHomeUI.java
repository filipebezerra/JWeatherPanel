package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JButton btnConsultWearther;

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
			public void actionPerformed(ActionEvent e) {
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
			public void mouseEntered(MouseEvent e) {
				JLabel instanceJLabel = (JLabel) e.getSource();
				instanceJLabel.setText("<html><u>" + instanceJLabel.getText()
						+ "</u>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel instanceJLabel = (JLabel) e.getSource();
				instanceJLabel.setFont(new Font(instanceJLabel.getFont()
						.getName(), 0, instanceJLabel.getFont().getSize()));
				instanceJLabel.setText(instanceJLabel.getText()
						.replace("<html>", "").replace("<u>", "")
						.replace("</u>", ""));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new HistoryUI().setVisible(true);
			}
		});
		lblLinkConsultHistory.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLinkConsultHistory.setBounds(595, 541, 189, 20);
		getContentPane().add(lblLinkConsultHistory);
		/*
		 * contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5,
		 * 5, 5, 5)); contentPane.setLayout(new BorderLayout(0, 0));
		 * setContentPane(contentPane);
		 */}
}
