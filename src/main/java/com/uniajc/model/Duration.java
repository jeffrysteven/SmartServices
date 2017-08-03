package com.uniajc.model;

public class Duration {
	
	private Long inSeconds;
	private String humanReadable;
	
	public Duration(Long inSeconds, String humanReadable) {
		super();
		this.inSeconds = inSeconds;
		this.humanReadable = humanReadable;
	}

	public Long getInSeconds() {
		return inSeconds;
	}

	public void setInSeconds(Long inSeconds) {
		this.inSeconds = inSeconds;
	}

	public String getHumanReadable() {
		return humanReadable;
	}

	public void setHumanReadable(String humanReadable) {
		this.humanReadable = humanReadable;
	}
}
