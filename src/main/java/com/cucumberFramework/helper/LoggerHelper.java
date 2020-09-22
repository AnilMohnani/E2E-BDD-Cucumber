package com.cucumberFramework.helper;

import org.apache.logging.log4j.LogManager;

public class LoggerHelper {

	public static org.apache.logging.log4j.Logger getLogger(Class<?> cls) {

		return LogManager.getLogger(cls);

	}
}