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
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.dom4j.DocumentException;

import br.ucg.cmp1017.jweatherpanel.controller.HomeControllerImpl;
import br.ucg.cmp1017.jweatherpanel.controller.IHomeController;
import br.ucg.cmp1017.jweatherpanel.model.entity.WeatherAbstractModel;

import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;

/**
 * Classe responsável por ser o ponto de entrada da aplicação e executar o
 * formulário principal da aplicação.
 * 
 * @author Filipe Bezerra
 * 
 */
public class ApplicationHomeUI extends JFrame implements Serializable,
		WindowFocusListener {

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
	private static final long serialVersionUID = 4395743645388772923L;

	/**
	 * Campo de entrada de um nome de país para pesquisa de cidades disponíveis
	 * para obter informações de clima
	 */
	private JTextField txtFieldCountryName;

	/**
	 * Campo de saída com lista de cidades disponíveis para obter informações de
	 * clima
	 */
	private JComboBox<String> cmbBoxListCities;

	/**
	 * Botão que executa a consulta de cidades levando em conta o país informado
	 */
	private JButton btnSearchCities;

	/**
	 * Botão que executa a consulta de clima levando em conta o país e a cidade
	 * informados
	 */
	private JButton btnConsultWearther;

	/**
	 * Controller responsável pelos eventos disparados nesta view e que precisam
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
	 * 
	 */
	private JScrollPane scrollPaneTableDetails;

	/**
	 * 
	 */
	private JTable tableDetails;

	/**
	 * 
	 */
	private ObjectTableModel<WeatherAbstractModel> tableModelDetails;

	/**
	 * 
	 */
	private AnnotationResolver resolver;
	private JLabel lblChooseCity;

	/**
	 * Esta cadeira de carateres (String) armazena o último país pesquisado ao
	 * webservice pela lista de cidades. Servirá como um buffer para que numa
	 * mesma pesquisa, não envie várias requisições do mesmo país
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
					lblChooseCity.setLocation(
							lblMsgTxtFieldCountryNameRequired.getX()
									+ lblMsgTxtFieldCountryNameRequired
											.getWidth(), lblChooseCity.getY());
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
	 */
	private void setProcessWaitCursor() {
		Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
		getContentPane().setCursor(cursor);
	}

	/**
	 * 
	 */
	private void setDefaultCursor() {
		Cursor cursor = Cursor.getDefaultCursor();
		getContentPane().setCursor(cursor);
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

		setProcessWaitCursor();
		try {
			homeController.searchCities(countryName);
		} catch (RemoteException e) {
			JOptionPane
					.showMessageDialog(
							this,
							"Não foi possível completar a requisição. O motivo pode "
									+ "ser falta de conexão com a internet ou o host de destino "
									+ "ou o serviço está indisponível!",
							"Error Attempting Search Cities",
							JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setDefaultCursor();
		}

		if (cmbBoxListCities.getItemCount() == 0) {
			JOptionPane.showMessageDialog(this,
					"No city was found to the country searched \""
							+ countryName
							+ " \". Try again with another country!",
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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
						lblChooseCity.setLocation(cmbBoxListCities.getX(),
								lblChooseCity.getY());
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
		btnSearchCities.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					invokeCitiesSearch();
				}
			}
		});
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
		btnSearchCities.setDisplayedMnemonicIndex(0);
		btnSearchCities.setMnemonic(KeyEvent.VK_S);
		getContentPane().add(btnSearchCities);

		btnConsultWearther = new JButton("Consult Weather");
		btnConsultWearther.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					invokeWeatherSearch();
				}
			}
		});
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
		btnConsultWearther.setDisplayedMnemonicIndex(8);
		btnConsultWearther.setMnemonic(KeyEvent.VK_W);
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
		lblMsgTxtFieldCountryNameRequired.setBounds(134, 98, 155, 20);
		getContentPane().add(lblMsgTxtFieldCountryNameRequired);

		lblMsgCmbBoxListCitiesRequired = new JLabel("This field is required!");
		lblMsgCmbBoxListCitiesRequired.setVisible(false);
		lblMsgCmbBoxListCitiesRequired.setForeground(Color.RED);
		lblMsgCmbBoxListCitiesRequired.setFont(new Font("Verdana", Font.PLAIN,
				14));
		lblMsgCmbBoxListCitiesRequired.setBounds(134, 151, 155, 20);
		getContentPane().add(lblMsgCmbBoxListCitiesRequired);

		resolver = new AnnotationResolver(WeatherAbstractModel.class);
		tableModelDetails = new ObjectTableModel<>(resolver,
				"country,city,originalDate,visibility,temperature");
		tableDetails = new JTable(tableModelDetails);
		scrollPaneTableDetails = new JScrollPane();
		scrollPaneTableDetails.setViewportView(tableDetails);
		scrollPaneTableDetails.setBounds(10, 176, 774, 354);
		getContentPane().add(scrollPaneTableDetails);

		JLabel lblCountryName = new JLabel("Country Name");
		lblCountryName.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCountryName.setLabelFor(txtFieldCountryName);
		lblCountryName.setName("lblCountryName");
		lblCountryName.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCountryName.setBounds(134, 46, 111, 20);
		getContentPane().add(lblCountryName);

		lblChooseCity = new JLabel("Choose one city");
		lblChooseCity.setDisplayedMnemonic(KeyEvent.VK_O);
		lblChooseCity.setLabelFor(cmbBoxListCities);
		lblChooseCity.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblChooseCity.setName("lblChooseCity");
		lblChooseCity.setBounds(134, 98, 121, 20);
		lblChooseCity.setDisplayedMnemonicIndex(7);
		getContentPane().add(lblChooseCity);
	}

	/**
	 * Define uma aparência e comportamento para a interface swing utilizando
	 * L&F padrão da JRE e inicializa e executa a aplicação.
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

		addWindowFocusListener(this);
		createAndInitComponents();
		homeController = new HomeControllerImpl(this);
	}

	/**
	 * Obter campo que armazena o argumento de pesquisa pela lista de países
	 * disponíveis para obter informações do clima
	 * 
	 * @return Campo com texto para pesquisa de países e todos seus atributos
	 * 
	 */
	public JTextField getTxtFieldCountryName() {
		return txtFieldCountryName;
	}

	/**
	 * Obter campo que armazena a lista de cidades disponíveis para obter
	 * informações do clima
	 * 
	 * @return Campo com lista de cidades e todos seus atributos
	 */
	public JComboBox<String> getCmbBoxListCities() {
		return cmbBoxListCities;
	}

	/**
	 * Alterar a lista de cidades disponíveis para obter informações de clima
	 * 
	 * @param cmbBoxListCities
	 *            Lista de nomes de cidades
	 */
	public void setCmbBoxListCities(final JComboBox<String> cmbBoxListCities) {
		this.cmbBoxListCities = cmbBoxListCities;
	}

	/**
	 * 
	 * @return
	 */
	public JScrollPane getScrollPaneTableDetails() {
		return scrollPaneTableDetails;
	}

	/**
	 * 
	 * @param scrollPaneTableDetails
	 */
	public void setScrollPaneTableDetails(JScrollPane scrollPaneTableDetails) {
		this.scrollPaneTableDetails = scrollPaneTableDetails;
	}

	/**
	 * 
	 * @return
	 */
	public JTable getTableDetails() {
		return tableDetails;
	}

	/**
	 * 
	 * @param tableDetails
	 */
	public void setTableDetails(JTable tableDetails) {
		this.tableDetails = tableDetails;
	}

	/**
	 * 
	 * @return
	 */
	public ObjectTableModel<WeatherAbstractModel> getTableModelDetails() {
		return tableModelDetails;
	}

	/**
	 * 
	 * @param tableModelDetails
	 */
	public void setTableModelDetails(
			ObjectTableModel<WeatherAbstractModel> tableModelDetails) {
		this.tableModelDetails = tableModelDetails;
	}

	/**
	 * 
	 * @return
	 */
	public AnnotationResolver getResolver() {
		return resolver;
	}

	/**
	 * 
	 * @param resolver
	 */
	public void setResolver(AnnotationResolver resolver) {
		this.resolver = resolver;
	}

	@Override
	/**
	 * 
	 */
	public void windowGainedFocus(WindowEvent e) {
		setEnabled(true);
	}

	@Override
	/**
	 * 
	 */
	public void windowLostFocus(WindowEvent e) {
		setEnabled(false);
	}
}
