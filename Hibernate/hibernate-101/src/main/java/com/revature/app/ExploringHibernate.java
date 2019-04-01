package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger log = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {

		merge();
	}
	static User save() {
		User u = new User("Poo Bear", "Hibernates!");				//transient
		
		//get a session so that we can call methods of the session interface
		Session session = util.getSession();		//cannot try with resources. Does not implement auto-close
		log.info("Opened a session. " + session);
		try {
			//in Hibernate,we must manage our transaction.
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);							//Persistent
			tx.commit();
			u.setId(id);
		}
		finally {
			log.info("About to Close Session");
			session.close();						//Now  u is detached.
		}
		return u;
	}
	
	static void saveVSpersist() {
		User u = new User(1,"test", "user");	//need constructor method that changes Id to work.
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(u);					//change to persist 
			//Above worked with save(); but with persist,we get a persistentObjectException.
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	static void persist() {				//Persist cannot pass an id.
		User u = new User("test", "user");	//need constructor method that changes Id to work.
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(u);					//change to persist 
			//Above worked with save(); but with persist,we get a persistentObjectException.
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	//Get--
	//returns object, need to cast. EAGER
	static User get(int id) {
		Session session = util.getSession();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}
	
	static User load(int id) {
		Session session = util.getSession();
		User u = (User) session.load(User.class, id);
		session.close();
		return u;
	}
	static void update () {
		Session session = util.getSession();
		try {
			User u = new User("new user","test");
			Transaction tx = session.beginTransaction();
			u.setUsername("Changed This Username");
			session.update(u);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	static void merge() {
		Session session = util.getSession();
		try {
			User u = new User("new user","test");
			Transaction tx = session.beginTransaction();
			u.setUsername("Username Changed");
			session.merge(u);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	static User findByUsername (String username) {
		User u = null;
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from User where lower(username) = :param");
			query.setParameter("param", username.toLowerCase());
			u = (User) query.uniqueResult();					//single result
		}
		finally {
			session.close();
		}
		return u;
	}
	
}
