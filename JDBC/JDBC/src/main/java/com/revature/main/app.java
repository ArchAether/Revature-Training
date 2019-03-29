package com.revature.main;

import com.revature.data.UserDAO;
import com.revature.model.User;
import com.revature.service.UserService;

public class app {
	public static void main(String[] args) {
		UserService service = new UserService();
		System.out.println(service.addUser(new User("testuser", "admin","administrative test user")));
	}
}
