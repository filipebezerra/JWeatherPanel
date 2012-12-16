package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe concreta respons�vel armazenar e transportar o dom�nio da aplica��o,
 * ou seja, as caracter�sticas e comportamentos das informa��es. O objetivo
 * desta classe � armazenar permanentemente cada consulta realizada ao
 * webservice, guardando exatamente como os dados foram retornados e servir como
 * uma c�pia consist�ncias das dados
 * 
 * @author Filipe Bezerra
 * 
 */
public class WeatherHistory extends WeatherAbstractModel implements
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
	 * 
	 */
	private static final long serialVersionUID = -5376344757681743451L;

	/**
	 * Construtor padr�o
	 */
	public WeatherHistory() {
		super();
	}

	/**
	 * Construtor informando unicamente o identificador �nico do registro na
	 * tabela
	 * 
	 * @param id
	 *            Valor do identificador �nico na tabela
	 * 
	 */
	public WeatherHistory(final long id) {
		this.id = id;
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
	public WeatherHistory(final Date originalDate, final String country,
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
	 * Descri��o da inst�ncia baseada em suas caracter�sticas (atributos)
	 * 
	 * @return Valor da descri��o da inst�ncia
	 * 
	 */
	@Override
	public String toString() {
		return "WeatherHistory [location=" + location + ", time=" + time
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
		WeatherHistory other = (WeatherHistory) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
