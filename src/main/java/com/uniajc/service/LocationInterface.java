package com.uniajc.service;

/**
 * @author jlenis
 *
 */
public interface LocationInterface {
	/**
	 * @param {String} address
	 * @return {Long} - duration in seconds to UNIAJC.
	 */
	public Long getTravelDurationToUNIAJC(String address);
}
