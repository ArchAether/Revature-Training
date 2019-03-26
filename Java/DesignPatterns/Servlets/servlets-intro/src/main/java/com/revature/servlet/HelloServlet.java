package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends GenericServlet{

	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(HelloServlet.class); //Use Apache's logger
	int count = 0;
	
	//--Init--
	@Override
	public void init() throws ServletException {
		super.init();
		logger.trace("Initializing Generic Servlet");
	}
	
	//---Serial--
	private static final long serialVersionUID = -1222605197265571187L;

	//--Service()--
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		logger.trace("In hello Servlet(GENERIC SERVLET) Service Method");
		
		PrintWriter writer = res.getWriter();
		
		String context = getServletContext().getInitParameter("environmentVar");
		String config = getServletConfig().getInitParameter("helloConfig");
		
		String respText = "<h1>Hello Servlet!</h1><br>"+"this is a response from our Generic Servlet Class <br>"
		+ "Request Count: "+ ++count + "<br>"+"ServletContext: " + context + "<br>" + "ServletConfig: "+config;		
		
		res.setContentType("text/html");
		
		writer.write(respText);
		
		
	}
		
	//--Destroy--
	@Override
	public void destroy() {
		super.destroy();
		logger.trace("Destroying Generic Servlet");
	}
	
}
