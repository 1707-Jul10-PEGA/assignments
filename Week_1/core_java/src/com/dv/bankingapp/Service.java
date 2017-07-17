package com.dv.bankingapp;

import org.apache.log4j.Logger;

public class Service {

	private static Logger log = Logger.getRootLogger();
	
	/* eof
	 * notifies when the end of file has been reached for data files
	 */
	public void eof(String msg) {
		log.warn(msg);
	}

}
