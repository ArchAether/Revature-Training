package com.revature.JDBC;

public class Singleton {
	/*
	 * Design pattern that is used when only one instance of an object is needed.
	 * will have a Private constructor and a public getInstance() method
	 */
	private String name;
	
	static {
		System.out.println("this is a static 'initializer' block that runs as soon as the class is loaded.");
	}
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		System.out.println("constructing Singleton object");
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}
