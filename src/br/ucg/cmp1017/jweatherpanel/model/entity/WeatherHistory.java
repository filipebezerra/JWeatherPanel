package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe concreta responsável armazenar e transportar o domínio da aplicação,
 * ou seja, as características e comportamentos das informações. O objetivo
 * desta classe é armazenar permanentemente cada consulta realizada ao
 * webservice, guardando exatamente como os dados foram retornados e servir como
 * uma cópia consistências das dados
 * 
 * @author Filipe Bezerra
 * 
 */
public class WeatherHistory extends WeatherAbstractModel implements
		Serializable {

	/**
	 * ID de identificação da versão da classe para manter controle da evolução
	 * 
	 * @category Serialização de objetos
	 * 
	 * @see {@link http www.javapractices.com/topic/TopicAction.do?Id=45} ou
	 * @see {@link http blog.caelum.com.br/entendendo-o-serialversionuid/}
	 * @see {@link http
	 *      docs.oracle.com/javase/1.4.2/docs/api/java/io/Serializable.html}
	 * 
	 */
	private static final long serialVersionUID = -5376344757681743451L;

	/**
	 * Construtor padrão
	 */
	public WeatherHistory() {
		super();
	}

	/**
	 * Construtor informando unicamente o identificador único do registro na
	 * tabela
	 * 
	 * @param id
	 *            Valor do identificador único na tabela
	 * 
	 */
	public WeatherHistory(final long id) {
		this.id = id;
	}

	/**
	 * Construtor com atributos completo com exceção do identificador único da
	 * tabela
	 * 
	 * @param originalDate
	 *            Valor data/hora da requisição de consulta ao webservice
	 * @param country
	 *            Valor do país da consulta do tempo
	 * @param city
	 *            Valor da cidade da consulta do tempo
	 * @param location
	 *            Valor da localização da consulta do tempo
	 * @param time
	 *            Valor da data/hora da consulta do tempo
	 * @param wind
	 *            Valor do vento da consulta do tempo
	 * @param visibility
	 *            Valor da visilidade da consulta do tempo
	 * @param skyConditions
	 *            Valor das condições do céu da consulta do tempo
	 * @param temperature
	 *            Valor da temperatura da consulta do tempo
	 * @param windchill
	 *            Valor da sensação do tempo da consulta do tempo
	 * @param dewPoint
	 *            Valor do ponto de orvalho da consulta do tempo
	 * @param relativeHumidity
	 *            Valor da humidade relativa do ar da consulta do tempo
	 * @param pressure
	 *            Valor da pressão da consulta do tempo
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
	 * Descrição da instância baseada em suas características (atributos)
	 * 
	 * @return Valor da descrição da instância
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
	 * @return Valor interno da instância
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
	 * Comparação da instância com uma outra instância, onde é comparado se
	 * ambos apontam para a mesma referência, se a referência é inválida, se
	 * pertencem à uma mesma classificação e se contém o mesmo identificador
	 * único do registro na tabela
	 * 
	 * @return Valor verdadeiro ou falso da comparação
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
