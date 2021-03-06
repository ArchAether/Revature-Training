package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	private static Logger log =  Logger.getLogger(RegisterServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("got to the doPost");
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(req.getInputStream(),User.class);
		
		user = service.addUser(user);
		
		if (user == null) {
			resp.setStatus(400);
		}
		else {
			resp.setStatus(201); 		//CREATED
			resp.setContentType("application/json");
			PrintWriter writer = resp.getWriter();
			writer.write(mapper.writeValueAsString(user));
		}
	}
	

}
