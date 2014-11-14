package com.ph.publisher.ejb.services.impl;

import com.ph.publisher.ejb.services.interfaces.LoggerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 4/09/14
 * Time: 08:19 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class SimpleLoggerService implements LoggerService {

    private static final Log logger = LogFactory.getLog(SimpleLoggerService.class);

    @Override
    public void start() {
        try {
            testLogs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void testLogs() throws Exception {

        for(int i=1 ; i<=300 ; i++){
            if((i%2)==1){
                logger.debug("Tests INFO log =====" + i);

            }
            else{
                logger.info("Tests INFO log ====="+i);
                pause(400);
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
