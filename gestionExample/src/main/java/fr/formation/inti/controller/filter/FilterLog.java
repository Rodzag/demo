package fr.formation.inti.controller.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entity.User;

/**
 * Servlet Filter implementation class FilterLog
 */
//@WebFilter("/*")
public class FilterLog implements Filter {
	private static final Log log = LogFactory.getLog(FilterLog.class);
	private ServletContext context;

	/**
	 * Default constructor.
	 */
	public FilterLog() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	
		 res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		 res.setHeader("Pragma", "no-cache");
		 res.setDateHeader("Expires", 0); // Proxies.


			
		HttpSession session = req.getSession(false);
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + " ::Request Params::{" + name + "=" + value + "}");
		}
		String uri = req.getRequestURI();
		this.context.log("Requested Resource :"+uri);
		User ident;
		ident=null;
		try {
		ident = (User) session.getAttribute("user");
		}catch (Exception e) {
			log.info("pas d'authentification");			
		}
		if(ident == null && !(uri.endsWith("index.jsp")||uri.endsWith("Connexion.jsp")||uri.endsWith("IdentifServelt")||uri.endsWith("logout")||uri.endsWith("css"))) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("Connexion.jsp");
		}else {
			log.info("doFilter before ");
			log.info(session);
			chain.doFilter(request, response);
			log.info("doFilter after");			
			log.info(session == null);
;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLogginFilter initialized");

	}


}
