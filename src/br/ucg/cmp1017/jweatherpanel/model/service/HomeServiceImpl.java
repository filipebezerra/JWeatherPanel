package br.ucg.cmp1017.jweatherpanel.model.service;

import java.util.ArrayList;
import java.util.List;

import br.ucg.cmp1017.jweatherpanel.model.entity.City;
import br.ucg.cmp1017.jweatherpanel.model.entity.WeatherConsult;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * @author Filipe Bezerra
 * 
 */
public class HomeServiceImpl implements IHomeService {

	private String doConvertToTypedXml(String untypedXml) {
		String resultXml = untypedXml
				.replaceAll("Country",
						City.class.getDeclaredFields()[1].getName())
				.replaceAll("City", City.class.getDeclaredFields()[0].getName())
				.replaceAll("Table", City.class.getCanonicalName())
				.replaceAll("NewDataSet", "list");
		return resultXml;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitiesXmlToCitiesList(String citiesXml) {
		String newCitiesXml = doConvertToTypedXml(citiesXml);

		XStream stream = new XStream(new DomDriver());
		List<City> citiesList = new ArrayList<>();
		citiesList = (List<City>) stream.fromXML(newCitiesXml);

		return citiesList;
	}

	@Override
	public WeatherConsult getWeatherConsult(final String weatherXml) {
		// TODO Auto-generated method stub
		return null;
	}
}
