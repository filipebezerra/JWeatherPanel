package br.ucg.cmp1017.jweatherpanel.controller;

import java.rmi.RemoteException;

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
	 */
	void searchCities(String countryName) throws RemoteException;

	/**
	 * 
	 * @param countryName
	 * @param cityName
	 * @throws RemoteException
	 */
	void consultWeather(String countryName, String cityName)
			throws RemoteException;

	/**
	 * 
	 * @param idRecord
	 */
	void callDetailsController(int idRecord);
}
