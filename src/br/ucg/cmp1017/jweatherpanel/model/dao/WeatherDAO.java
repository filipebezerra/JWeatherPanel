package br.ucg.cmp1017.jweatherpanel.model.dao;

import java.util.List;

import br.ucg.cmp1017.jweatherpanel.model.entity.WeatherAbstractModel;

public class WeatherDAO extends GenericDao<WeatherAbstractModel> implements
		IWeatherPersistence {

	public WeatherDAO() throws Exception {
		super();
	}

	@Override
	public List<WeatherAbstractModel> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(WeatherAbstractModel weather) throws Exception {
		String insertSQL = "insert into weather_consults (originalDate, country, city, "
				+ "location, wind, visibility, skyConditions ,temperature, "
				+ "dewPoint, relativeHumidity, pressure) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		insert(insertSQL, weather);
		return false;
	}

	@Override
	public boolean updatet(WeatherAbstractModel weather) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(WeatherAbstractModel weather) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
