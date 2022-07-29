package org.simoes.lpd.test;

import org.simoes.lpd.util.*;
import org.simoes.util.*;

import java.io.*;
import java.util.*;

import junit.framework.*;
import org.apache.log4j.Logger;


public class TestUtil extends TestCase {
	static Logger log = Logger.getLogger(TestUtil.class);
	
	public TestUtil(String name) {
		super(name);
	}
	
	protected void setUp() {
	}
	
	public void testReadNextInput() {
		final String METHOD_NAME = "testReadNextInput(): ";
		byte[] testCommand = {0x2, 
							  0x35, 0x35, 0x35, 0x35, 
							  0x20, 
							  0x36, 0x36, 0x36, 0x36, 
							  0xA };
		NetUtil netUtil = new NetUtil();
		ByteArrayInputStream bais = new ByteArrayInputStream(testCommand);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			byte[] result = netUtil.readNextInput(bais, baos);
			assertNotNull(result);
			assertTrue(11 == result.length);
		} catch(IOException e) {
			log.error(METHOD_NAME + e.getMessage(), e);
			fail(METHOD_NAME + e.getMessage());
		}
	}
	
	public void testParseCommand() {
		final String METHOD_NAME = "testParseCommand(): ";
		byte[] testCommand = {0x2, 
							  0x47, 0x4C, 0x45, 0x4E,  0x4E,
							  0xA };
		Vector result = StringUtil.parseCommand(testCommand);
		assertNotNull(result);
		assertTrue(2 == result.size());
	}
	
	public void testCreateFixedLengthString() {
		final String METHOD_NAME = "testCreateFixedLengthString(): ";
		String test1 = "ABC";
		String test2 = "ABCDE";
		String test3 = "ABCDEF.";
		String expected1 = "ABC   ";
		int expected1Length = 6;
		String expected2 = "AB";
		int expected2Length = 2;
		String expected3 = "ABCDEF.";
		int expected3Length = 7;
		
		assertTrue(expected1.equals(StringUtil.createFixedLengthString(test1, expected1Length)));
		assertTrue(expected2.equals(StringUtil.createFixedLengthString(test2, expected2Length)));
		assertTrue(expected3.equals(StringUtil.createFixedLengthString(test3, expected3Length)));
	}

}