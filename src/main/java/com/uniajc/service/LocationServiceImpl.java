package com.uniajc.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Location;
import com.uniajc.utils.LoggerUtil;

public class LocationServiceImpl implements LocationInterface{
	
	/**
	 * Project properties.
	 */
	private Properties prop = new Properties();
	
	/**
	 * Project properties loader.
	 */
	private InputStream input = ConnectionDB.class.getClassLoader().getResourceAsStream("config.properties");
	
	/**
	 * Logger Helper.
	 */
	private LoggerUtil logger = LoggerUtil.getInstance();
	
	/**
	 * Google API key.
	 */
	private String apiKey; 
	
	/**
	 * Get Google api key.
	 */
	public LocationServiceImpl() {
		try {
			prop.load(input);
			this.apiKey = prop.getProperty("mapsApiKey");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Exception occur", e);
		}
	}

	@Override
	public Location getTravelDurationToUNIAJC(String address) {
		try {
			GeoApiContext context = new GeoApiContext.Builder().apiKey(this.apiKey).build();
			DistanceMatrix result = new DistanceMatrixApiRequest(context).
					origins(address).destinations("Cl. 25 #127-220, Cali, Valle del Cauca, Colombia")
					.mode(TravelMode.TRANSIT).await();
			return new Location(result.rows[0].elements[0].duration.inSeconds, result.rows[0].elements[0].distance.inMeters);
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Maps location error", e);
			return null;
		}
	}

}
