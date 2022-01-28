package fr.formation.inti.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {
	private static final Log log = LogFactory.getLog(ContextListener.class);

    /**
     * Default constructor. 
     */
    public ContextListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	log.info("----------> the application stoped");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	log.info("----------> the application started");
    }
	
}
