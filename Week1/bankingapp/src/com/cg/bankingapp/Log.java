package com.cg.bankingapp;

import org.apache.log4j.Logger;

public class Log {
	private static Logger logs = Logger.getRootLogger();
	
	public static void log(String msg, int i) {
		switch(i) {
		case 1:
			logs.info("INFO: " + msg);
			break;
		case 2:
			logs.info("DEBUG: " + msg);
		case 3:
			logs.warn("WARN: " + msg);
			break;
		case 4:
			logs.trace("TRACE: " + msg);
			break;
		case 5:
			logs.error("ERROR: " + msg);
			break;
		case 6:
			logs.fatal("FATAL: " + msg);
			break;
		}
		
	}
}
