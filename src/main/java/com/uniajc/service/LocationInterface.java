package com.uniajc.service;

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
}
