package com.uniajc.model;

import java.util.List;

public class Teacher {
	
	private Person person;
	private boolean activeContract;
	private String initDate;
	private String endDate;
	private String vinculationType;
	private List<Title> titles;
	
	public Teacher() {}

	public Teacher(Person person, boolean activeContract, String initDate, String endDate, String vinculationType,
			List<Title> titles) {
		super();
		this.person = person;
		this.activeContract = activeContract;
		this.initDate = initDate;
		this.endDate = endDate;
		this.vinculationType = vinculationType;
		this.titles = titles;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean getActiveContract() {
		return activeContract;
	}

	public void setActiveContract(boolean activeContract) {
		this.activeContract = activeContract;
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

	public String getVinculationType() {
		return vinculationType;
	}

	public void setVinculationType(String vinculationType) {
		this.vinculationType = vinculationType;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
}
