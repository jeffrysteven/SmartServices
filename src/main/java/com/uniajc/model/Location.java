package com.uniajc.model;

public class Location {
	
	private Duration durationToUNIAJC;
	private Distance distanceToUNIAJC;
	
	public Location(Duration durationToUNIAJC, Distance distanceToUNIAJC) {
		super();
		this.durationToUNIAJC = durationToUNIAJC;
		this.distanceToUNIAJC = distanceToUNIAJC;
	}

	public Duration getDurationToUNIAJC() {
		return durationToUNIAJC;
	}

	public void setDurationToUNIAJC(Duration durationToUNIAJC) {
		this.durationToUNIAJC = durationToUNIAJC;
	}

	public Distance getDistanceToUNIAJC() {
		return distanceToUNIAJC;
	}

	public void setDistanceToUNIAJC(Distance distanceToUNIAJC) {
		this.distanceToUNIAJC = distanceToUNIAJC;
	}
	
}
