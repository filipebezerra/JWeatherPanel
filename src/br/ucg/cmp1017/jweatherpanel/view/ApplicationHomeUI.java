package br.ucg.cmp1017.jweatherpanel.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.ucg.cmp1017.jweatherpanel.controller.HomeControllerImpl;
import br.ucg.cmp1017.jweatherpanel.controller.IHomeController;

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
	private JTextField txtFieldCountryName;

	/**
	 * Campo de sa�da com lista de cidades dispon�veis para obter informa��es de
	 * clima
	 */
	private JComboBox<String> cmbBoxListCities;

	/**
	 * Bot�o que executa a consulta de cidades levando em conta o pa�s informado
	 */
	private JButton btnSearchCities;

	/**
	 * Bot�o que executa a consulta de clima levando em conta o pa�s e a cidade
	 * informados
	 */
	private JButton btnConsultWearther;

	/**
	 * Controller respons�vel pelos eventos disparados nesta view e que precisam
	 * ser interpretados e executados
	 */
	private final IHomeController homeController;

	/**
	 * 
	 */
	private JLabel lblMsgCmbBoxListCitiesRequired;

	/**
	 * 
	 */
	private JLabel lblMsgTxtFieldCountryNameRequired;

	/**
	 * Esta cadeira de carateres (String) armazena o �ltimo pa�s pesquisado ao
	 * webservice pela lista de cidades. Servir� como um buffer para que numa
	 * mesma pesquisa, n�o envie v�rias requisi��es do mesmo pa�s
	 */
	// private String lastCountrySearchedAndNotFound = "";

	/**
	 * 
	 * @param source
	 * @return
	 */
	private boolean isFilledRequiredFields(Object source) {
		lblMsgTxtFieldCountryNameRequired.setVisible(false);
		lblMsgCmbBoxListCitiesRequired.setVisible(false);
		boolean filledTxtFieldCountryName = txtFieldCountryName.getText() != null
				&& !txtFieldCountryName.getText().isEmpty();
		boolean filledCmbBoxListCities = cmbBoxListCities.getSelectedIndex() != -1;

		if (source.equals(btnSearchCities)) {
			if (!filledTxtFieldCountryName) {
				if (!lblMsgTxtFieldCountryNameRequired.isVisible()) {
					lblMsgTxtFieldCountryNameRequired.setVisible(true);
				}
				txtFieldCountryName.requestFocusInWindow();
				return false;
			}
		} else if (source.equals(btnConsultWearther)) {
			if (!filledTxtFieldCountryName || !filledCmbBoxListCities) {
				if (!filledCmbBoxListCities) {
					if (!lblMsgCmbBoxListCitiesRequired.isVisible()) {
						lblMsgCmbBoxListCitiesRequired.setVisible(true);
					}
					cmbBoxListCities.requestFocusInWindow();
				}

				if (!filledTxtFieldCountryName) {
					if (!lblMsgTxtFieldCountryNameRequired.isVisible()) {
						lblMsgTxtFieldCountryNameRequired.setVisible(true);
					}
					txtFieldCountryName.requestFocusInWindow();
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param countryName
	 */
	private void invokeCitiesSearch() {
		if (!isFilledRequiredFields(btnSearchCities))
			return;

		String countryName = txtFieldCountryName.getText();

		// if (countryName.equalsIgnoreCase(lastCountrySearchedAndNotFound))
		// return;
		// else {
		// lastCountrySearchedAndNotFound = countryName;
		// }

		try {
			homeController.searchCities(countryName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (cmbBoxListCities.getItemCount() == 0) {
			JOptionPane.showMessageDialog(this,
					"No city was found to the country searched ' "
							+ countryName
							+ " '. Try again with another country!",
					"Search Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void invokeWeatherSearch() {
		if (!isFilledRequiredFields(btnConsultWearther))
			return;

		String countryName = txtFieldCountryName.getText();
		String cityName = cmbBoxListCities.getSelectedItem().toString();

		try {
			homeController.consultWeather(countryName, cityName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Cria, inicializa e adiciona eventos dos componentes do frame.
	 * 
	 */
	private void createAndInitComponents() {
		txtFieldCountryName = new JTextField();
		txtFieldCountryName
				.setToolTipText("Enter here the name of the country to be searched. After typing press [ENTER] to perform the search.");
		txtFieldCountryName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					invokeCitiesSearch();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (txtFieldCountryName.getText() != null
						&& !txtFieldCountryName.getText().isEmpty())
					if (lblMsgTxtFieldCountryNameRequired.isVisible()) {
						lblMsgTxtFieldCountryNameRequired.setVisible(false);
					}

				if (txtFieldCountryName.getText() == null
						|| txtFieldCountryName.getText().isEmpty())
					if (cmbBoxListCities.getItemCount() > 0) {
						cmbBoxListCities.removeAllItems();
					}
			}
		});
		txtFieldCountryName.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldCountryName.setBounds(134, 67, 479, 30);
		getContentPane().add(txtFieldCountryName);
		txtFieldCountryName.setColumns(10);

		cmbBoxListCities = new JComboBox<String>();
		cmbBoxListCities
				.setToolTipText("Select here the item that corresponds to the city to consult their meteorology.");
		cmbBoxListCities.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbBoxListCities.setFont(new Font("Verdana", Font.PLAIN, 14));
		cmbBoxListCities.setBounds(134, 120, 479, 30);
		getContentPane().add(cmbBoxListCities);

		btnSearchCities = new JButton("Search Cities");
		btnSearchCities
				.setToolTipText("Click here to perform the search. This search returns the names of the cities researched if were found. The result is added in the field of items below.");
		btnSearchCities.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchCities.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSearchCities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				invokeCitiesSearch();
			}
		});
		btnSearchCities.setBounds(623, 67, 161, 30);
		getContentPane().add(btnSearchCities);

		btnConsultWearther = new JButton("Consult Weather");
		btnConsultWearther
				.setToolTipText("Click here to perform research of weather forecasting.");
		btnConsultWearther.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				invokeWeatherSearch();
			}
		});
		btnConsultWearther.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultWearther.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnConsultWearther.setBounds(623, 120, 161, 30);
		getContentPane().add(btnConsultWearther);

		JLabel lblLinkConsultHistory = new JLabel("Go to Consult History >>");
		lblLinkConsultHistory.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLinkConsultHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(final MouseEvent e) {
				JLabel instanceJLabel = (JLabel) e.getSource();
				instanceJLabel.setForeground(Color.blue);
				instanceJLabel.setText("<html><u>" + instanceJLabel.getText()
						+ "</u>");
			}

			@Override
			public void mouseExited(final MouseEvent e) {
				JLabel instanceJLabel = (JLabel) e.getSource();
				instanceJLabel.setFont(new Font(instanceJLabel.getFont()
						.getName(), 0, instanceJLabel.getFont().getSize()));
				instanceJLabel.setForeground(Color.black);
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

		lblMsgTxtFieldCountryNameRequired = new JLabel(
				"This field is required!");
		lblMsgTxtFieldCountryNameRequired.setVisible(false);
		lblMsgTxtFieldCountryNameRequired.setForeground(Color.RED);
		lblMsgTxtFieldCountryNameRequired.setFont(new Font("Verdana",
				Font.PLAIN, 14));
		lblMsgTxtFieldCountryNameRequired.setBounds(134, 45, 155, 20);
		getContentPane().add(lblMsgTxtFieldCountryNameRequired);

		lblMsgCmbBoxListCitiesRequired = new JLabel("This field is required!");
		lblMsgCmbBoxListCitiesRequired.setVisible(false);
		lblMsgCmbBoxListCitiesRequired.setForeground(Color.RED);
		lblMsgCmbBoxListCitiesRequired.setFont(new Font("Verdana", Font.PLAIN,
				14));
		lblMsgCmbBoxListCitiesRequired.setBounds(134, 98, 155, 20);
		getContentPane().add(lblMsgCmbBoxListCitiesRequired);
	}

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
	 * Organiza o layout do frame.
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
		createAndInitComponents();
		homeController = new HomeControllerImpl(this);
	}

	/**
	 * Obter campo que armazena o argumento de pesquisa pela lista de pa�ses
	 * dispon�veis para obter informa��es do clima
	 * 
	 * @return Campo com texto para pesquisa de pa�ses e todos seus atributos
	 * 
	 */
	public JTextField getTxtFieldCountryName() {
		return txtFieldCountryName;
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
