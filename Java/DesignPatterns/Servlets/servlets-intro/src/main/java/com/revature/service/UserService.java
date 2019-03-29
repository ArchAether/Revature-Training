package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;

public class UserService {

	private static List<User> users = new ArrayList<User>();
	int identity = 3;
	static {
		users.add(new User("genesis", "123", "awesome trainer, she's awesome!"));
		users.add(new User("Patrick", "manager", "Keeps the place running."));
		
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getByUsername(String name) {
		/*for(User u: users) {
			if(name.equalsIgnoreCase(u.getUsername())) {
				return u;
			}
			return null;
		}*/
		return users.stream().filter(u-> u.getUsername().equalsIgnoreCase(name))
		.findFirst()
		.orElse(null);
		
		//Does the same thing.
	}
	public User addUser(User u) {
		if(getByUsername(u.getUsername().toString()) == null) {
		users.add(u);
		u.setId(identity++);
			}	
		return u;
	}
	
	
}
