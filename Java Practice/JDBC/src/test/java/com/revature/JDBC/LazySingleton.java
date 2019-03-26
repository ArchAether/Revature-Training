package com.revature.JDBC;

public class LazySingleton {
	private static LazySingleton instance; //ONLY Declare. Instantiate when asked.
	
	private LazySingleton() {
		System.out.println("constructing LazySingleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
