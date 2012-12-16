package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class WeatherConsult implements Serializable {
	private long id;
	private Date originalDate;
	private String country;
	private String city;
	private String location;
	private Date time;
	private String wind;
	private String visibility;
	private String skyConditions;
	private String temperature;
	private String windchill;
	private String dewPoint;
	private float relativeHumidity;
	private float pressure;
	private long idHistory;

	public WeatherConsult() {
		super();
	}

	public WeatherConsult(final long id, final long idHistory) {
		this.id = id;
		this.idHistory = idHistory;
	}

	public WeatherConsult(final Date originalDate, final String country,
			final String city, final String location, final Date time,
			final String wind, final String visibility,
			final String skyConditions, final String temperature,
			final String windchill, final String dewPoint,
			final float relativeHumidity, final float pressure) {
		this.originalDate = originalDate;
		this.country = country;
		this.city = city;
		this.location = location;
		this.time = time;
		this.wind = wind;
		this.visibility = visibility;
		this.skyConditions = skyConditions;
		this.temperature = temperature;
		this.windchill = windchill;
		this.dewPoint = dewPoint;
		this.relativeHumidity = relativeHumidity;
		this.pressure = pressure;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public Date getOriginalDate() {
		return originalDate;
	}

	public void setOriginalDate(final Date originalDate) {
		this.originalDate = originalDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(final Date time) {
		this.time = time;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(final String wind) {
		this.wind = wind;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(final String visibility) {
		this.visibility = visibility;
	}

	public String getSkyConditions() {
		return skyConditions;
	}

	public void setSkyConditions(final String skyConditions) {
		this.skyConditions = skyConditions;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(final String temperature) {
		this.temperature = temperature;
	}

	public String getWindchill() {
		return windchill;
	}

	public void setWindchill(final String windchill) {
		this.windchill = windchill;
	}

	public String getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(final String dewPoint) {
		this.dewPoint = dewPoint;
	}

	public float getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(final float relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(final float pressure) {
		this.pressure = pressure;
	}

	public long getIdHistory() {
		return idHistory;
	}

	public void setIdHistory(final long idHistory) {
		this.idHistory = idHistory;
	}

	@Override
	public String toString() {
		return "WeatherConsult [location=" + location + ", time=" + time
				+ ", skyConditions=" + skyConditions + ", temperature="
				+ temperature + ", relativeHumidity=" + relativeHumidity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ id >>> 32);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherConsult other = (WeatherConsult) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
