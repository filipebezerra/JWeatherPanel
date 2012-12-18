package br.ucg.cmp1017.jweatherpanel.model.service;

import java.util.List;

import br.ucg.cmp1017.jweatherpanel.model.entity.City;
import br.ucg.cmp1017.jweatherpanel.model.entity.WeatherConsult;

/**
 * 
 * @author Filipe Bezerra
 * 
 */
public interface IHomeService {
	List<City> getCitiesXmlToCitiesList(String citiesXml);

	WeatherConsult getWeatherConsult(String weatherXml);
}
