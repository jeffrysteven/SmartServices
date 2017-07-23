package com.uniajc.model;

public class Person {
	
	private int id;
	private String idNumber;
	private String fullName;
	private String address;
	private String mail;
	private String phoneNumber;
	private String cellphoneNumber;
	private String birthDate;
	private String maritalStatus;
	private String genre;
	private String rh;
	private String city;
	
	public Person() {}

	public Person(int id, String idNumber, String fullName, String address, String mail, String phoneNumber,
			String cellphoneNumber, String birthDate, String maritalStatus, String genre, String rh, String city) {
		super();
		this.id = id;
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.address = address;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.cellphoneNumber = cellphoneNumber;
		this.birthDate = birthDate;
		this.maritalStatus = maritalStatus;
		this.genre = genre;
		this.rh = rh;
		this.city = city;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", idNumber=" + idNumber + ", fullName=" + fullName + ", address=" + address
				+ ", mail=" + mail + ", phoneNumber=" + phoneNumber + ", cellphoneNumber=" + cellphoneNumber
				+ ", birthDate=" + birthDate + ", maritalStatus=" + maritalStatus + ", genre=" + genre + ", rh=" + rh
				+ ", city=" + city + "]";
	}
	
}
