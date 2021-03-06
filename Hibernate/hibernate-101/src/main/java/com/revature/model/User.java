package com.revature.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BLOG_USER")
public class User {
	
	@Id	//makes it a primary key
	@Column(name = "USER_ID")	//not nessessary
	@SequenceGenerator(name = "U_SEQ_GEN", sequenceName = "BLOG_USER_SEQ", allocationSize=1) //auto-generating ids
	@GeneratedValue(generator = "U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name  = "FOLLOWING",
	joinColumns = @JoinColumn(name = "USER_ID"),
	inverseJoinColumns = @JoinColumn(name = "FOLLOWS"))
	private Set<User> following = new HashSet<User>();
	
	
	public User() {
		
	}
	
		public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
		
	public User(int id, String username, String password) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
		}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}


}
