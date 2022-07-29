package org.simoes.lpd.test;

import junit.framework.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.simoes.lpd.common.*;

// assertNotNull(msg, object);
// assertTrue(msg, boolean);

public class TestPrintFile extends TestCase {
    
	// logger
	static Logger log = Logger.getLogger(TestPrintFile.class);
    
	// initialize log4j
	static {
	PropertyConfigurator.configure("logConfig.ini");
	}
    
	// constructor
	public TestPrintFile(String name) {
		super(name);
	}
    
	// setup
	protected void setUp() {
	}
    
	// tests
	public void testDataFileClone() {
		final String METHOD_NAME = "testDataFileClone";
		try {
			byte[] byteArray = {1,2,3};
			byte[] byteArray2 = {0,2,3};
			
			DataFile df = new DataFile();
			df.setContents(byteArray);
			DataFile copy = (DataFile)df.clone();
			log.debug(METHOD_NAME + "df=" + df.getContents());
			log.debug(METHOD_NAME + "copy=" + copy.getContents());
			byte[] dfArray = df.getContents();
			dfArray[0] = 0;
			log.debug(METHOD_NAME + "df=" + df.getContents());
			log.debug(METHOD_NAME + "copy=" + copy.getContents());
			assertTrue(1 == copy.getContents()[0]);
            
		} catch(Exception e) {
			final String msg = e.getMessage();
			log.fatal(msg, e);
			fail(METHOD_NAME + " " + msg);
		}
	}

}
