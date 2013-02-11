package br.ucg.cmp1017.jweatherpanel.model.service;

import java.util.List;

import org.dom4j.DocumentException;

import br.ucg.cmp1017.jweatherpanel.model.entity.City;
import br.ucg.cmp1017.jweatherpanel.model.entity.WeatherConsult;

/**
 * 
 * @author Filipe Bezerra
 * 
 */
public interface IHomeService {
	List<City> getCitiesXmlToCitiesList(String citiesXml);

	WeatherConsult getWeatherConsult(String countryName, String cityName,
			String weatherXml) throws DocumentException, Exception;
}
