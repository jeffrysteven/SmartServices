package com.uniajc.model;

public class ContactData {
	
	private String address;
	private String mail;
	private String phoneNumber;
	private String cellphoneNumber;
	private String city;
	
	public ContactData() {}

	public ContactData(String address, String mail, String phoneNumber, String cellphoneNumber, String city) {
		this.address = address;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.cellphoneNumber = cellphoneNumber;
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
