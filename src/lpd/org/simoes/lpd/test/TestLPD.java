package org.simoes.lpd.test;

import junit.framework.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLPD {
	static Logger log = Logger.getLogger(TestLPD.class);

	public static Test suite() {
		PropertyConfigurator.configure("logConfig.ini");
		TestSuite suite = new TestSuite();
		suite.addTest(new TestUtil("testReadNextInput"));
		return suite();
	}
	
	
}