package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.io.Serializable;
import java.util.Date;

public class WeatherConsult extends WeatherAbstractModel implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6155527785439185547L;
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
