import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 14/08/14
 * Time: 04:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLogger extends TestCase{

    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    public void testLogs() throws Exception {

        //DOMConfigurator.configure("publicador-war/src/test/resources/logback.xml");

        for(int i=1 ; i<=1000 ; i++){
            if((i%2)==1){
                logger.debug("Tests INFO log =====" + i);

            }
            else{
                logger.info("Tests INFO log ====="+i);
                pause(500);
            }

        }

    }


    private void pause(int milliSecs){

        try {
            Thread.sleep(milliSecs);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

}
