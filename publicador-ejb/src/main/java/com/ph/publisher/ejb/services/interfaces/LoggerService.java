package com.ph.publisher.ejb.services.interfaces;

import org.jboss.ejb3.annotation.LocalBinding;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 4/09/14
 * Time: 08:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
@LocalBinding(jndiBinding = "LoggerService/local")
public interface LoggerService {

    public void start();

}
