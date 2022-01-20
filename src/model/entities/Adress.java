package model.entities;

import java.io.Serializable;

public class Adress implements Serializable{
	private String street;
	private String number;
	private String city;
	private String country;
	
	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adress(String street, String number, String city, String country) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return street + "#" + number + "#" + city + "#" + country;
	}
	
}
