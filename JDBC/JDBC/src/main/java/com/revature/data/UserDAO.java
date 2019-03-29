package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;

/*
 * The DAO should be the only place where a connection is made to the database
 * this design pattern allows for a separation of concerns and allows
 * for a nice cohesive code.
 * 
 * JDBC - Java Database connectivity
 * 
 * ONLY Place to see create and delete methods
 */
public class UserDAO {
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//Try in SQL Manager before in JDBC
			
			String query = "select * from demo_user";
		
		//Statement interface
		Statement statement = conn.createStatement();
		
		//result set interface
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			User temp = new User(
					rs.getInt(1),
					rs.getString("username"),
					rs.getString(3),
					rs.getString("bio"));
			users.add(temp);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	//Prepared statement to execute query
	public User getByUsername(String username) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select* from demo_user where lower(username) = ?"; //set to ?. Can make multiple ? for indexes
			PreparedStatement ps = conn.prepareStatement(sql);					//"compiles" code
			ps.setString(1,username.toLowerCase());							//(Index, Value)
			ResultSet rs = ps.executeQuery();					//Get user back
			if(rs.next()) {
				u = new User(
						rs.getInt(1),
						rs.getString("username"),
						rs.getString(3),
						rs.getString("bio"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	// Persist data. execute update
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//conn.setAutoCommit(); is set to true
			
			String sql = "insert into demo_user(username, password, bio)\r\n" + 
					"values(?, ?, ? )";
			String[] keyNames = {"u_id"}; //We want these keynames to be sent back. Otherwise we only get how many rows
											// were affected. Specify auto generated fields to get back
			
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getBio());		//(index number, key)
			
			int numRowsAffected = ps.executeUpdate();
			// could also call this method without setting equal to anything
			
			System.out.println("Added "+numRowsAffected + " User(s) to DB");
			
			if(numRowsAffected == 1) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				u.setId(pk.getInt(1));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
