package com.uniajc.model;

public class Title {
	
	private String titleName;
	private String dateObtained;
	private String institution;
	
	public Title() {}
	
	public Title(String titleName, String dateObtained, String institution) {
		this.titleName = titleName;
		this.dateObtained = dateObtained;
		this.institution = institution;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDateObtained() {
		return dateObtained;
	}

	public void setDateObtained(String dateObtained) {
		this.dateObtained = dateObtained;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "Title [titleName=" + titleName + ", dateObtained=" + dateObtained + ", institution=" + institution
				+ "]";
	}
	
}
