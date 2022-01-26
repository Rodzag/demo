package fr.formation.inti.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {
private static final Log log = LogFactory.getLog(SessionListener.class);
    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    	HttpSession sessionName = se.getSession();
    	log.info("----------> session created "+sessionName);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	log.info("----------> session stoped");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
    	Object attributeValue = event.getValue();
    	log.info("----------> session attribute added : name= "+attributeName+" value= "+attributeValue);
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
    	Object attributeValue = event.getValue();
    	log.info("----------> session attribute removed : name= "+attributeName+" value= "+attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  {
    	String attributeName = event.getName();
    	Object attributeValue = event.getValue();
    	log.info("----------> session attribute replaced : name= "+attributeName+" value= "+attributeValue);
    }
	
}
