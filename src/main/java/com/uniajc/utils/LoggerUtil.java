package com.uniajc.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author jlenis
 *
 */
public class LoggerUtil {
	
	/**
	 * Class instance singleton.
	 */
	public static final LoggerUtil LOGGERINSTANCE = new LoggerUtil();
	
	/**
	 * Init Logger.
	 */
	private final Logger loggerObj = Logger.getLogger("SmartServices");
	
	
	/**
	 * Init logger and settings.
	 */
	public LoggerUtil() {
		try {
			FileHandler fileHandler = new FileHandler("SmartServices.log");
			loggerObj.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			fileHandler.setLevel(Level.ALL);
		} catch (SecurityException | IOException e) {
			loggerObj.log(Level.SEVERE, "Error occur in FileHandler.", e);
		}
	}
	
	/**
	 * @return Class instance.
	 */
	public static LoggerUtil getInstance() {
		return LOGGERINSTANCE;
	}
	
	/**
	 * @param l - Level log.
	 * @param logMsg - Message
	 * @param thrown - Exception
	 */
	public void log(Level l, String logMsg, Throwable thrown) {
		loggerObj.log(l, logMsg, thrown);
	}
	
}
