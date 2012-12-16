package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.util.Date;

public abstract class WeatherAbstractModel {
	protected long id;
	protected Date originalDate;
	protected String country;
	protected String city;
	protected String location;
	protected Date time;
	protected String wind;
	protected String visibility;
	protected String skyConditions;
	protected String temperature;
	protected String windchill;
	protected String dewPoint;
	protected float relativeHumidity;
	protected float pressure;

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
}
