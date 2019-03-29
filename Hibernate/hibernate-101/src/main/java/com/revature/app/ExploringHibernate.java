package com.revature.app;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ExploringHibernate {

	static ConnectionUtil util = ConnectionUtil.getInstance();
	final static Logger log = Logger.getLogger(ExploringHibernate.class);
	
	public static void main(String[] args) {
		save();
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
			session.close();
		}
		return u;
	}
}
