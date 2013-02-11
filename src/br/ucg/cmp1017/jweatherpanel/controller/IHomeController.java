package br.ucg.cmp1017.jweatherpanel.controller;

import java.rmi.RemoteException;

import org.dom4j.DocumentException;

/**
 * 
 * @author Filipe Bezerra
 * 
 */
public interface IHomeController {

	/**
	 * 
	 * @param countryName
	 * @throws RemoteException
	 * @throws Exception
	 */
	void searchCities(String countryName) throws RemoteException, Exception;

	/**
	 * 
	 * @param countryName
	 * @param cityName
	 * @throws RemoteException
	 * @throws Exception
	 */
	void consultWeather(String countryName, String cityName)
			throws RemoteException, DocumentException, Exception;

	/**
	 * 
	 * @param idRecord
	 */
	void callDetailsController(int idRecord);
}
