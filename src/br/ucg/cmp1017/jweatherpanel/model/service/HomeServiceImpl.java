package br.ucg.cmp1017.jweatherpanel.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import br.ucg.cmp1017.jweatherpanel.model.dao.WeatherDAO;
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
	private final WeatherDAO dao;

	public HomeServiceImpl() throws Exception {
		dao = new WeatherDAO();
	}

	private String doConvertXmlToCitiesXml(String untypedXml) {
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
		String newCitiesXml = doConvertXmlToCitiesXml(citiesXml);

		XStream stream = new XStream(new DomDriver());
		List<City> citiesList = new ArrayList<>();
		citiesList = (List<City>) stream.fromXML(newCitiesXml);

		return citiesList;
	}

	@Override
	public WeatherConsult getWeatherConsult(final String countryName,
			final String cityName, final String weatherXml) throws Exception {
		WeatherConsult weatherConsult = new WeatherConsult();
		Document document = DocumentHelper.parseText(weatherXml);
		Element root = document.getRootElement();

		weatherConsult.setCountry(countryName);
		weatherConsult.setCity(cityName);
		weatherConsult.setOriginalDate(new Date());
		if (root.element("Location") != null) {
			weatherConsult.setLocation(root.element("Location")
					.getStringValue().trim());
		}
		if (root.element("Wind") != null) {
			weatherConsult.setWind(root.element("Wind").getStringValue());
		}
		if (root.element("Visibility") != null) {
			weatherConsult.setVisibility(root.element("Visibility")
					.getStringValue().trim());
		}
		if (root.element("SkyConditions") != null) {
			weatherConsult.setSkyConditions(root.element("SkyConditions")
					.getStringValue().trim());
		}
		if (root.element("Temperature") != null) {
			weatherConsult.setTemperature(root.element("Temperature")
					.getStringValue().trim());
		}
		if (root.element("DewPoint") != null) {
			weatherConsult.setDewPoint(root.element("DewPoint")
					.getStringValue().trim());
		}
		if (root.element("RelativeHumidity") != null) {
			weatherConsult.setRelativeHumidity(Float.parseFloat(root
					.element("RelativeHumidity").getStringValue()
					.substring(0, 3).trim()));
		}
		if (root.element("Pressure") != null) {
			weatherConsult.setPressure(Float.parseFloat(root
					.element("Pressure").getStringValue().substring(0, 6)
					.trim()));
		}

		dao.insert(weatherConsult);

		return weatherConsult;
	}
}
