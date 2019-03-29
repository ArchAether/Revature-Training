package com.revature.pojos;

public class User {
	
	private String username;
	private String password;
	private String bio;
	private int id;
	
	public User(String username, String password, String bio, int id) {
		super();
		this.username = username;
		this.password = password;
		this.bio = bio;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User() {}
	
	public User(String username, String password, String bio) {
		super();
		this.username = username;
		this.password = password;
		this.bio = bio;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", bio=" + bio + "]";
	}

	
	
}
