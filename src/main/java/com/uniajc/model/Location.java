package com.uniajc.model;

public class Location {
	
	private Long tripDurationToUNIAJCInSeconds;
	private Long tripDistanceToUNIAJCInMeters;
	
	public Location(Long tripDurationToUNIAJCInSeconds, Long tripDistanceToUNIAJCInMeters) {
		this.tripDurationToUNIAJCInSeconds = tripDurationToUNIAJCInSeconds;
		this.tripDistanceToUNIAJCInMeters = tripDistanceToUNIAJCInMeters;
	}

	public Long getTripDurationToUNIAJCInSeconds() {
		return tripDurationToUNIAJCInSeconds;
	}

	public void setTripDurationToUNIAJCInSeconds(Long tripDurationToUNIAJCInSeconds) {
		this.tripDurationToUNIAJCInSeconds = tripDurationToUNIAJCInSeconds;
	}

	public Long getTripDistanceToUNIAJCInMeters() {
		return tripDistanceToUNIAJCInMeters;
	}

	public void setTripDistanceToUNIAJCInMeters(Long tripDistanceToUNIAJCInMeters) {
		this.tripDistanceToUNIAJCInMeters = tripDistanceToUNIAJCInMeters;
	}
	
}
