package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet(loadOnStartup = 2, urlPatterns= {"/users"}) //replaces web.xml annotation. No need for name
public class UserServlet extends HttpServlet{
	
	
	
	static UserService service  = new UserService();
	private static Logger log = Logger.getLogger(UserServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users=service.getAll();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(req.getInputStream(), User.class); //need .class file
		log.trace("ADDING USER: "+ user.toString());
		user = service.addUser(user);
		
		if(user == null) {							//Check if User is created. Change HTTP Status accordingly
			resp.setStatus(409);
		}
		else {
			resp.setStatus(201);
		}
		
	}
}
