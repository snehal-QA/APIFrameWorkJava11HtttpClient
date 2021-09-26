package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//It is for handling Log configuration and setup. Logs will be available at /target
public class Log {
	
	 // Initialize Log4j logs
    static {
        String log4jpath=System.getProperty("user.dir")+"/src/test/resources/log4j.xml";
        System.setProperty("logoutputpath", System.getProperty("user.dir"));
        System.setProperty("log4j.configurationFile",log4jpath);
    }

    private static Logger log = LogManager.getLogger(Log.class.getName());//

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName){
        log.info("-----------------------------------------------------------------------------------------");
        log.info(">> " + sTestCaseName);
        log.info("-----------------------------------------------------------------------------------------");
    }

    //This is to print log for the ending of the test case

    public static void endTestCase(String sTestCaseName){
        log.info("-----------------------------------------------------------------------------------------");
        log.info(">> " + sTestCaseName);
        log.info("-----------------------------------------------------------------------------------------");
    }

    // Log level methods

    public static void info(String message) {

        log.info(">> " + message);

    }

    public static void warn(String message) {

        log.warn("!! " + message + " !!");;

    }

    public static void error(String message, Exception e) {

        log.error("## " + message +" ##" ,e);

    }

    public static void fatal(String message) {

        log.fatal("** " + message + " **");

    }

    public static void debug(String message) {

        log.debug("@@ " +  message + " @@" );

    }


}
