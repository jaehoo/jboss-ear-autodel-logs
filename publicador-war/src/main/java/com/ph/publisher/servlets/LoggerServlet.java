package com.ph.publisher.servlets;

import com.ph.publisher.ejb.services.interfaces.LoggerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 3/09/14
 * Time: 06:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoggerServlet extends HttpServlet {

    private static final Log logger = LogFactory.getLog(LoggerServlet.class);
    private LoggerService ls;

    public void init() {

        logger.info("==== START SERVLET");
        try {
            InitialContext initialContext = new InitialContext();
            this.ls= ((LoggerService) initialContext.lookup("LoggerService/local"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("doGet ==> ");

        String opt= req.getParameter("log");

        if(opt != null && opt.equals("1")){
            logger.info("TEST ========= INFO");
            logger.debug("TEST ========= DEBUG");
            logger.error("TEST ========= ERROR");
        }
        else
        {
            ls.start();
        }

    }


}
