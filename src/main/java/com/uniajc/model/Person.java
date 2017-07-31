package com.uniajc.model;

import com.uniajc.service.LocationServiceImpl;

/**
 * @author jlenis
 *
 */
public class Person {
	
	private int id;
	private String idNumber;
	private String fullName;
	private String birthDate;
	private String genre;
	private String rh;
	private ContactData contact;
	private Location locationToUNIAJC;
	
	public Person() {}

	public Person(int id, String idNumber, String fullName, String birthDate, String genre, String rh, ContactData contact) {
		this.id = id;
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.genre = genre;
		this.rh = rh;
		this.contact = contact;
		this.locationToUNIAJC = new LocationServiceImpl().getTravelDurationToUNIAJC(contact.getAddress() + ", " + contact.getCity());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public ContactData getContact() {
		return contact;
	}

	public void setContact(ContactData contact) {
		this.contact = contact;
	}

	public Location getLocationToUNIAJC() {
		return locationToUNIAJC;
	}

	public void setLocationToUNIAJC(Location locationToUNIAJC) {
		this.locationToUNIAJC = locationToUNIAJC;
	}
}
