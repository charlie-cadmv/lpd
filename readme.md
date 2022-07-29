# LPD printer implementation by Chris Samoes
Copied from http://lpdspooler.sourceforge.net/

## To run:
`./runServer.sh` or `runServer.bat`

## To add this virtual printer in Windows 10 for testing
* Open the Windows printer UI dialog with `rundll32 printui.dll PrintUIEntry /im`
* Choose "Add a local printer or network printer with manual settings"
* Click "Next"
* Choose "Create a new port" and choose "Standard TCP/IP Port"
* Click "Next"
* In "Hostname or IP address" enter 127.0.0.1
* In Port name: choose "IP_127.0.0.1"
* Click "Next"
* Wait a while for it to not be found.
* Choose "Custom" and click "Settings"
* Change the Port Number to "515" (if it's grayed out change Protocol to "Raw" first, then change the Port Number to "515")
* Change "Protocol" to "LPR"
* Set the "Queue Name" to "RAW"
* Leave the boxes unchecked
* Click "Next"
* "Generic", "Generic/Text Only"
* "Keep existing driver"
* Set "Printer Name" to "LPR_LOCAL"
* Skip the test print and click "Finish"
* 
Make sure you have the LPD server started.
Choose th e"LPR_LOCAL" printer from notepad to test it.