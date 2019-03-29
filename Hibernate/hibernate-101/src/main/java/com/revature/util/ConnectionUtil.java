package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtil {

	
	private static ConnectionUtil cu;
	private SessionFactory sf;

	public synchronized static ConnectionUtil getInstance() {
		if(cu == null) {
			cu = new ConnectionUtil();
		}
		return cu;
	}
	
	private synchronized SessionFactory getSessionFactory() {
		if(sf == null) {
		
			Configuration hibConfig = new Configuration().configure();
			
			ServiceRegistry registry = new ServiceRegistryBuilder()
					.applySettings(hibConfig.getProperties())
					.buildServiceRegistry();
			
			sf = hibConfig.buildSessionFactory(registry);
		}
		return sf;
	}
	
	public Session getSession() {
		return this.getSessionFactory().openSession();
	}
	
}