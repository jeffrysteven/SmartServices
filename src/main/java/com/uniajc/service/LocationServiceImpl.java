package com.uniajc.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import com.uniajc.db.ConnectionDB;
import com.uniajc.model.Distance;
import com.uniajc.model.Duration;
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
			DistanceMatrixElement addressData = result.rows[0].elements[0];
			return new Location(new Duration(addressData.duration.inSeconds, addressData.duration.humanReadable), 
					new Distance(addressData.distance.inMeters, addressData.distance.humanReadable));
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Maps location error", e);
			return null;
		}
	}
	
	@Override
	public List<Location> getTravelDurationToUNIAJCFromList(JsonArray addressesArr, int place) {
		try {
			StringBuilder addresses = new StringBuilder();
			for (int i = 0; i < addressesArr.size(); i++) {
				JsonObject addressOBJ = (JsonObject) addressesArr.get(i); 
				addresses.append(addressOBJ.get("address") + ", " + addressOBJ.get("city"));
				if (i<addressesArr.size()-1) {
					addresses.append(" | ");
				}
			}
			ArrayList<Location> locationToUNIAJC = new ArrayList<>();
			GeoApiContext context = new GeoApiContext.Builder().apiKey(this.apiKey).build();
			DistanceMatrix request = new DistanceMatrixApiRequest(context)
					.origins(addresses.toString())
					.destinations(place == 0 ? 
							"Avenida 6 norte # 28n 102, Cali" : 
								"Cl. 25 #127-220, Cali, Valle del Cauca, Colombia")
					.mode(TravelMode.TRANSIT).await();
				if(request.rows.length > 0) {
					DistanceMatrixRow[] results = request.rows;
					for (int i = 0; i < results.length; i++) {
						if(results[i].elements.length > 0) {
							DistanceMatrixElement addressData = results[i].elements[0];
							locationToUNIAJC.add(
									new Location(
											new com.uniajc.model.Duration(
													addressData.duration.inSeconds,
													addressData.duration.humanReadable
											), 
											new com.uniajc.model.Distance(
													addressData.distance.inMeters,
													addressData.distance.humanReadable)
											)
									);
						}
					}
					return locationToUNIAJC;
				} else {
					return Collections.emptyList();
				}
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Maps location error", e);
			return Collections.emptyList();
		}
	}

}
