package com.revature.model;

public class TestMapping {
	
	private int id;
	private String data;
	private String test;
	
	public TestMapping() {
		
	}
	
	public TestMapping(int id, String data, String test) {
		super();
		this.id = id;
		this.data = data;
		this.test = test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "TestMapping [id=" + id + ", data=" + data + ", test=" + test + "]";
	}
	
	
}
