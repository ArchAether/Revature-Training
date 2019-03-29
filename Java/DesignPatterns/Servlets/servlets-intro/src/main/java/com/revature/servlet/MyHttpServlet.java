package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.pojos.User;
import com.revature.service.UserService;


public class MyHttpServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(MyHttpServlet.class);
	static UserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("in HTTP Servlet --GET");
		PrintWriter writer = resp.getWriter();
		writer.write("Get METHOD RESPONSE");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("in HTTP Servlet --POST");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = service.getByUsername(username);
		
		PrintWriter writer=resp.getWriter();
		resp.setContentType("text/html");
		
		String output = "";
		
		if(user == null) {
			log.error("No such user exists");
			output="<strong>Incorrect user credentials. Return to home page and try again.</strong>";
		}
		else {
			if(password.equals(user.getPassword())) {
				log.info("User has logged in successfully");
				output = "<h1>Welcome, "+ user.getUsername()+"!</h1><br>"+ user.getBio();
			}
			else {
				log.info("Login failed!");
			}
		}
		writer.write(output);
	}
	
	
}
