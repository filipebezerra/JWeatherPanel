package br.ucg.cmp1017.jweatherpanel.model.entity;

/**
 * 
 * @author Filipe Bezerra
 * 
 */
public class City {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String country;

	/**
	 * 
	 */
	public City() {
	}

	/**
	 * 
	 * @param name
	 */
	public City(final String name, final String country) {
		this.name = name;
		this.country = country;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return name;
	}
}
