package com.uniajc.service;

import java.util.List;

import com.google.gson.JsonArray;
import com.uniajc.model.Location;

/**
 * @author jlenis
 *
 */
public interface LocationInterface {
	/**
	 * @param address
	 * @return {Long} - duration in seconds to UNIAJC.
	 */
	public Location getTravelDurationToUNIAJC(String address);
	
	/**
	 * @param addresses - JSON array
	 * @param place - UNIAJC place. Values are 0 - North, 1 - South.
	 * @return {JsonArray} - Location duration and distance Object to UNIAJC by address.
	 */
	public List<Location> getTravelDurationToUNIAJCFromList(JsonArray addresses, int place);
}
