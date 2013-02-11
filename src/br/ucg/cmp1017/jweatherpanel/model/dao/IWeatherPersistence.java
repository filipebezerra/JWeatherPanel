package br.ucg.cmp1017.jweatherpanel.model.dao;

import java.util.List;

import br.ucg.cmp1017.jweatherpanel.model.entity.WeatherAbstractModel;

public interface IWeatherPersistence {
	public List<WeatherAbstractModel> listAll() throws Exception;

	public boolean insert(WeatherAbstractModel weather) throws Exception;

	public boolean updatet(WeatherAbstractModel weather) throws Exception;

	public boolean delete(WeatherAbstractModel weather) throws Exception;
}
