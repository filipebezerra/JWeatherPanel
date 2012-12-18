package br.ucg.cmp1017.jweatherpanel.controller;

import java.rmi.RemoteException;
import java.util.List;

import br.ucg.cmp1017.globalweather.client.GlobalWeatherSoap;
import br.ucg.cmp1017.globalweather.client.GlobalWeatherSoapProxy;
import br.ucg.cmp1017.jweatherpanel.model.entity.City;
import br.ucg.cmp1017.jweatherpanel.model.service.HomeServiceImpl;
import br.ucg.cmp1017.jweatherpanel.model.service.IHomeService;
import br.ucg.cmp1017.jweatherpanel.view.ApplicationHomeUI;

/**
 * 
 * @author Filipe Bezerra
 * 
 */
public class HomeControllerImpl implements IHomeController {

	private final ApplicationHomeUI homeFrame;

	public HomeControllerImpl(final Object view)
			throws IllegalArgumentException {
		if (!(view instanceof ApplicationHomeUI))
			throw new IllegalArgumentException(
					"Erro de programação. Este Controller somente poderá conhecer "
							+ "Views de sua especialidade.");

		homeFrame = (ApplicationHomeUI) view;
	}

	@Override
	public void searchCities(final String countryName) throws RemoteException {
		GlobalWeatherSoap weather = new GlobalWeatherSoapProxy();
		String citiesXml = weather.getCitiesByCountry(countryName);
		IHomeService homeService = new HomeServiceImpl();
		List<City> citiesList = homeService.getCitiesXmlToCitiesList(citiesXml);

		homeFrame.getCmbBoxListCities().removeAllItems();
		if (citiesList.size() > 0) {
			for (City city : citiesList) {
				homeFrame.getCmbBoxListCities().addItem(city.getName());
			}
			homeFrame.getCmbBoxListCities().requestFocusInWindow();
		} else {
			homeFrame.getTxtFieldCountryName().requestFocusInWindow();
			homeFrame.getTxtFieldCountryName().selectAll();
		}
	}

	@Override
	public void consultWeather(final String countryName, final String cityName)
			throws RemoteException {
		GlobalWeatherSoap weather = new GlobalWeatherSoapProxy();
		String weatherXml = weather.getWeather(cityName, countryName);
		System.out.println(weatherXml);
	}

	@Override
	public void callDetailsController(final int idRecord) {

	}
}
