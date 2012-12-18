/**
 * GlobalWeather.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ucg.cmp1017.globalweather.client;

public interface GlobalWeather extends javax.xml.rpc.Service {
    public java.lang.String getGlobalWeatherSoapAddress();

    public br.ucg.cmp1017.globalweather.client.GlobalWeatherSoap getGlobalWeatherSoap() throws javax.xml.rpc.ServiceException;

    public br.ucg.cmp1017.globalweather.client.GlobalWeatherSoap getGlobalWeatherSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
