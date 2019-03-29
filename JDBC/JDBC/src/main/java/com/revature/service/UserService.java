package com.revature.service;

import com.revature.data.UserDAO;
import com.revature.model.User;

public class UserService {

	static UserDAO dao = new UserDAO();
	
	//Method will take two credentials at log in UN and Pass, and validate that a user with the name exists and
	//validate password.
	// make sure that your servlet layer passes the right values in.
	
	 public User logIn(String username, String password) {
		 User u = dao.getByUsername(username);
		 if(u == null) {
			 return null;
			 
			 }
		 else {
			 if(u.getPassword().equals(password)) {
				 return u;
			 }else {
			 return null;
			 }
		 }
		 
		 }
	 
	 public User addUser(User u) {
		 if(dao.getByUsername(u.getUsername())== null) {
			 return dao.addUser(u);
		 }
		 else {
			 return null;
		 }
	 }
}
