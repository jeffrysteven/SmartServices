package com.uniajc.model;

public class Teacher {
	
	private Person person;
	private String status;
	private String initDate;
	private String endDate;
	
	public Teacher() {}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
