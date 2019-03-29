package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*
 * We will Foward HTML here
 */
//@WebServlet("/loadView")
@WebServlet("*.view") // Anything that ends in .view will arrive this endpoint

public class LoadViewServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoadViewServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Forward
		
		String uri = req.getRequestURI();	//get the URI of the request
		String name = uri.substring(16, uri.length()-5);	//get the specific name of request(btwn intro/ and .view
		log.info("CHECK URI " + name);
		
		req.getRequestDispatcher("partials/"+name+".html").forward(req, resp); //Fowards req, resp to correct method.
		
		/*
		log.info("REQUEST SENT TO URI:" + req.getRequestURI());
		log.info("URL: " + req.getRequestURL());
		req.getRequestDispatcher(getResource(req.getRequestURI())).forward(req, resp);
		//Done more nicely above.
		*/
	}
	// don't need this
	/*private String getResource(String uri) {
		String resource = "partials/";
		
		switch (uri) { 
		case "/servlets-intro/landing.view": {
			resource += "landing.html";
			break;
			}
		}
		return resource;
	}*/
	
}
