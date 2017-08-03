package com.uniajc.model;

public class Distance {
	
	private Long inMeters;
	private String humanReadable;
	
	public Distance(Long inMeters, String humanReadable) {
		super();
		this.inMeters = inMeters;
		this.humanReadable = humanReadable;
	}

	public Long getInSeconds() {
		return inMeters;
	}

	public void setInSeconds(Long inMeters) {
		this.inMeters = inMeters;
	}

	public String getHumanReadable() {
		return humanReadable;
	}

	public void setHumanReadable(String humanReadable) {
		this.humanReadable = humanReadable;
	}
}
