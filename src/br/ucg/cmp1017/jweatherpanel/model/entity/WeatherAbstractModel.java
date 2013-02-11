package br.ucg.cmp1017.jweatherpanel.model.entity;

import java.util.Date;

import com.towel.el.annotation.Resolvable;

/**
 * Classe abstrata que � respons�vel por ser um modelo para as classes concretas
 * {@link WeatherConsult} e {@link WeatherHistory}.
 * 
 * @author Filipe Bezerra
 * 
 */
public abstract class WeatherAbstractModel {
	/**
	 * Valor identificador do registro
	 */
	protected long id;
	/**
	 * Valor data/hora da requisi��o de consulta ao webservice
	 */
	@Resolvable(colName = "Data/Hora")
	protected Date originalDate;
	/**
	 * Valor do pa�s da consulta do tempo
	 */
	@Resolvable(colName = "Pa�s")
	protected String country;
	/**
	 * Valor da cidade da consulta do tempo
	 */
	@Resolvable(colName = "Cidade")
	protected String city;
	/**
	 * Valor da localiza��o da consulta do tempo
	 */
	protected String location;
	/**
	 * Valor do vento da consulta do tempo
	 */
	protected String wind;
	/**
	 * Valor da visilidade da consulta do tempo
	 */
	@Resolvable(colName = "Visibilidade")
	protected String visibility;
	/**
	 * Valor das condi��es do c�u da consulta do tempo
	 */
	protected String skyConditions;
	/**
	 * Valor da temperatura da consulta do tempo
	 */
	@Resolvable(colName = "Temperatura")
	protected String temperature;
	/**
	 * Valor do ponto de orvalho da consulta do tempo
	 */
	protected String dewPoint;
	/**
	 * Valor da humidade relativa do ar da consulta do tempo
	 */
	protected float relativeHumidity;
	/**
	 * Valor da press�o da consulta do tempo
	 */
	protected float pressure;

	/**
	 * Abaixo s�o declarados e devidamente parametrizados os m�todos que a
	 * classe modelo deve prover para suas classes concretas, as quais t�m
	 * caracter�stica e comportamento de classes javabeans (ou POJO).
	 * 
	 */

	/**
	 * Obter valor do identificador �nico do registro na tabela. Gerado
	 * automaticamente e sequencialmente pelo sistema gerenciador de banco de
	 * dados (SGBD)
	 * 
	 * @return Valor do identificador do registro
	 * 
	 */
	public long getId() {
		return id;
	}

	/**
	 * Alterar valor do identificador �nico do registro na tabela. Gerado
	 * automaticamente e sequencialmente pelo sistema gerenciador de banco de
	 * dados (SGBD)
	 * 
	 * @param id
	 *            Valor identificador do registro
	 * 
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * Obter valor da data/hora que foi realizado a consulta ao webservice. Este
	 * � a data/hora que foi feita a requisi��o da consulta
	 * 
	 * @return Valor data/hora do momento que foi solicitado a consulta
	 * 
	 */
	public Date getOriginalDate() {
		return originalDate;
	}

	/**
	 * Alterar valor da data/hora que foi solicitado a consulta ao webservice.
	 * Este � a data/hora que foi feita a requisi��o da consulta
	 * 
	 * @param originalDate
	 *            Valor data/hora do momento que foi solicitado a consulta
	 * 
	 */
	public void setOriginalDate(final Date originalDate) {
		this.originalDate = originalDate;
	}

	/**
	 * Obter valor do pa�s. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor do pa�s
	 * 
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Alterar valor do p�is. Valor retornado da consulta ao webservice
	 * 
	 * @param country
	 *            Valor pa�s
	 * 
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * Obter valor da cidade. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor da cidade
	 * 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Alterar valor da cidade. Valor retornado da consulta ao webservice
	 * 
	 * @param city
	 *            Valor da cidade
	 * 
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * Obter valor da localiza��o. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor da localiza��o
	 * 
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Alterar valor da localiza��o. Valor retornado da consulta ao webservice
	 * 
	 * @param location
	 *            Valor da localiza��o
	 * 
	 */
	public void setLocation(final String location) {
		this.location = location;
	}

	/**
	 * Obter valor do vento. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor do vento
	 * 
	 */
	public String getWind() {
		return wind;
	}

	/**
	 * Alterar valor do vento. Valor retornado da consulta ao webservice
	 * 
	 * @param wind
	 *            Valor do vento
	 * 
	 */
	public void setWind(final String wind) {
		this.wind = wind;
	}

	/**
	 * Obter valor da visibilidade. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor da visibilidade
	 * 
	 */
	public String getVisibility() {
		return visibility;
	}

	/**
	 * Alterar valor da visibilidade. Valor retornado da consulta ao webservice
	 * 
	 * @param visibility
	 *            Valor da visibilidade
	 * 
	 */
	public void setVisibility(final String visibility) {
		this.visibility = visibility;
	}

	/**
	 * Obter valor das condi��es do c�u. Valor retornado da consulta ao
	 * webservice
	 * 
	 * @return Valor das condi��es do c�u
	 * 
	 */
	public String getSkyConditions() {
		return skyConditions;
	}

	/**
	 * Alterar valor das condi��es do c�u. Valor retornado da consulta ao
	 * webservice
	 * 
	 * @param skyConditions
	 *            Valor das condi��es do c�u
	 * 
	 */
	public void setSkyConditions(final String skyConditions) {
		this.skyConditions = skyConditions;
	}

	/**
	 * Obter valor da temperatura. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor da temperatura
	 * 
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * Alterar valor da temperatura. Valor retornado da consulta ao webservice
	 * 
	 * @param temperature
	 *            Valor da Temperatura
	 * 
	 */
	public void setTemperature(final String temperature) {
		this.temperature = temperature;
	}

	/**
	 * Obter valor do ponto de orvalho. Valor retornado da consulta ao
	 * webservice
	 * 
	 * @return Valor do ponto de orvalho
	 * 
	 */
	public String getDewPoint() {
		return dewPoint;
	}

	/**
	 * Alterar valor do ponto de orvalho. Valor retornado da consulta ao
	 * webservice
	 * 
	 * @param dewPoint
	 *            Valor do ponto de orvalho
	 * 
	 */
	public void setDewPoint(final String dewPoint) {
		this.dewPoint = dewPoint;
	}

	/**
	 * Obter valor da humidade relativa do ar. Valor retornado da consulta ao
	 * webservice
	 * 
	 * @return Valor da humidade relativa do ar
	 * 
	 */
	public float getRelativeHumidity() {
		return relativeHumidity;
	}

	/**
	 * Alterar valor da humidade relativa do ar. Valor retornado da consulta ao
	 * webservice
	 * 
	 * @param relativeHumidity
	 *            Valor da humidade relativa do ar
	 * 
	 */
	public void setRelativeHumidity(final float relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	/**
	 * Obter valor da press�o. Valor retornado da consulta ao webservice
	 * 
	 * @return Valor da press�o
	 * 
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * Alterar valor da press�o. Valor retornado da consulta ao webservice
	 * 
	 * @param pressure
	 *            Valor da press�o
	 * 
	 */
	public void setPressure(final float pressure) {
		this.pressure = pressure;
	}
}