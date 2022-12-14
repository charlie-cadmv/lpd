package org.simoes.lpd;

import org.simoes.lpd.handler.*;
import org.simoes.lpd.ui.*;
import org.simoes.lpd.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * Used to run our example code.  A user would want to rewrite this
 * or do away with it probably.  All needed objects are created in our main()
 * method to run a single print queue.  This also currently shows the 
 * print queue in a GUI.
 * 
 * @author Chris Simoes
 */
public class Main {
	static {
		PropertyConfigurator.configure("logConfig.ini");
	}
	static Logger log = Logger.getLogger(LPD.class);
	
	public static void main(String args[]) {
		log.debug("main(): STARTED");
		try {
			final String rawQueueName = "RAW";
			
			// Initialize data model and Print Queue
			PrintJobTableModel pjtm = new PrintJobTableModel();
			Queues queues = Queues.getInstance();
			// create the PrintQueue
			PrintQueue rawQueue = queues.createQueueWithTableModel(rawQueueName, pjtm);
			// initialize the TableModel by making it aware of it's data source, the PrintQueue
			pjtm.setPrintQueueDataModel(rawQueue);
			// start GUI
			PrintJobJFrame printJobJFrame = new PrintJobJFrame(pjtm); 
			printJobJFrame.setVisible(true);

			// Run the LPD spooler
			Thread lpdThread = new Thread(LPD.getInstance());
			lpdThread.start();
			
			// Setup the QueueMontior to process the rawQueue
			QueueMonitor rawQueueMonitor = new QueueMonitor(rawQueueName);
			Thread rawQueueMonitorThread = new Thread(rawQueueMonitor);
			rawQueueMonitorThread.start();

			//TODO: implement a way to end gracefully
		} catch(Exception e) {
			log.fatal(e.getMessage(), e);
		}
		log.debug("main(): FINSHED");

	}
}