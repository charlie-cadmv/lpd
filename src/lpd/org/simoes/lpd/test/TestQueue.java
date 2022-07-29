package org.simoes.lpd.test;

import junit.framework.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.simoes.lpd.util.Queue;

// assertNotNull(msg, object);
// assertTrue(msg, boolean);

public class TestQueue extends TestCase {
    
    // logger
    static Logger log = Logger.getLogger(TestQueue.class);
    
    // initialize log4j
    static {
	PropertyConfigurator.configure("logConfig.ini");
    }
    
    // constructor
    public TestQueue(String name) {
        super(name);
    }
    
    // setup
    protected void setUp() {
    }
    
    // tests
    public void testQueue0() {
        final String METHOD = "testQueue0";
        try {
            // 0. create queue
            Queue testQueue = new Queue("test queue");
	    assertTrue("initial size of queue is 0", testQueue.size() == 0);
            
            // 1. create some objects
            Integer i0 = new Integer(0);
            Integer i1 = new Integer(1);
            Integer i2 = new Integer(2);
            
            // 2. add to the queue
            long id0 = testQueue.add(i0);
	    assertTrue("size of queue after first add is 1", testQueue.size() == 1);
            long id1 = testQueue.add(i1);
	    assertTrue("size of queue is second add is 2", testQueue.size() == 2);
            long id2 = testQueue.add(i2);
	    assertTrue("size of queue is third add is 3", testQueue.size() == 3);
            
            // 3. remove objects
            Object o0 = testQueue.remove(id0);
	    assertTrue("size of queue after first remove is 2", testQueue.size() == 2);
            Object o1 = testQueue.remove(id1);
	    assertTrue("size of queue after second remove is 1", testQueue.size() == 1);
            Object o2 = testQueue.remove(id2);
	    assertTrue("size of queue after third remove is 0", testQueue.size() == 0);
            
            // 4. compare objects
	    assertTrue("comparing objects before and after adding/removing from the queue",
		       o0.equals(i0) && o1.equals(i1) && o2.equals(i2));
            
        } catch(Exception e) {
            final String msg = e.getMessage();
            log.fatal(msg, e);
            fail(METHOD + " " + msg);
        }
    }
}
