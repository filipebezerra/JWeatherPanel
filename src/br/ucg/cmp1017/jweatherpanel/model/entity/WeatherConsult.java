package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe concreta respons�vel armazenar e transportar o dom�nio da aplica��o,
 * ou seja, as caracter�sticas e comportamentos das informa��es. O objetivo
 * desta classe � armazenar os dados retornados do webservice, sendo que poder�o
 * sofrer opera��es SQL de altera��o ou dele��o
 * 
 * @author Filipe Bezerra
 * 
 */
public class WeatherConsult extends WeatherAbstractModel implements
		Serializable {
	/**
	 * ID de identifica��o da vers�o da classe para manter controle da evolu��o
	 * 
	 * @category Serializa��o de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 * @see {@link http
	 *      docs.oracle.com/javase/1.4.2/docs/api/java/io/Serializable.html}
	 */
	private static final long serialVersionUID = 6155527785439185547L;
	/**
	 * Valor do identificador da c�pia consistente deste mesmo registro tabela
	 */
	private long idHistory;

	/**
	 * Construtor padr�o
	 */
	public WeatherConsult() {
		super();
	}

	/**
	 * Construtor informando unicamente os identificadores �nico do registro na
	 * tabela din�mica e na outra permanente
	 * 
	 * @param id
	 *            Valor do identificador �nico na tabela din�mica
	 * @param idHistory
	 *            Valor do identificador �nico na tabela permanente
	 * 
	 */
	public WeatherConsult(final long id, final long idHistory) {
		this.id = id;
		this.idHistory = idHistory;
	}

	/**
	 * Construtor com atributos completo com exce��o do identificador �nico da
	 * tabela
	 * 
	 * @param originalDate
	 *            Valor data/hora da requisi��o de consulta ao webservice
	 * @param country
	 *            Valor do pa�s da consulta do tempo
	 * @param city
	 *            Valor da cidade da consulta do tempo
	 * @param location
	 *            Valor da localiza��o da consulta do tempo
	 * @param time
	 *            Valor da data/hora da consulta do tempo
	 * @param wind
	 *            Valor do vento da consulta do tempo
	 * @param visibility
	 *            Valor da visilidade da consulta do tempo
	 * @param skyConditions
	 *            Valor das condi��es do c�u da consulta do tempo
	 * @param temperature
	 *            Valor da temperatura da consulta do tempo
	 * @param windchill
	 *            Valor da sensa��o do tempo da consulta do tempo
	 * @param dewPoint
	 *            Valor do ponto de orvalho da consulta do tempo
	 * @param relativeHumidity
	 *            Valor da humidade relativa do ar da consulta do tempo
	 * @param pressure
	 *            Valor da press�o da consulta do tempo
	 * 
	 */
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

	/**
	 * Obter valor do identificador �nico da tabela permanente
	 * 
	 * @return Valor do identificador �nico
	 * 
	 */
	public long getIdHistory() {
		return idHistory;
	}

	/**
	 * Alterar valor do identificador �nico da tabela permanente
	 * 
	 * @param pressure
	 *            Valor do identificador �nico
	 * 
	 */
	public void setIdHistory(final long idHistory) {
		this.idHistory = idHistory;
	}

	/**
	 * Descri��o da inst�ncia baseada em suas caracter�sticas (atributos)
	 * 
	 * @return Valor da descri��o da inst�ncia
	 * 
	 */
	@Override
	public String toString() {
		return "WeatherConsult [location=" + location + ", time=" + time
				+ ", skyConditions=" + skyConditions + ", temperature="
				+ temperature + ", relativeHumidity=" + relativeHumidity + "]";
	}

	/**
	 * 
	 * 
	 * @return Valor interno da inst�ncia
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ id >>> 32);
		return result;
	}

	/**
	 * Compara��o da inst�ncia com uma outra inst�ncia, onde � comparado se
	 * ambos apontam para a mesma refer�ncia, se a refer�ncia � inv�lida, se
	 * pertencem � uma mesma classifica��o e se cont�m o mesmo identificador
	 * �nico do registro na tabela
	 * 
	 * @return Valor verdadeiro ou falso da compara��o
	 * 
	 */
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
