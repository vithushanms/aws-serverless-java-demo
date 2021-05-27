package com.serverless;

import java.util.Date;
import java.util.Map;

public class Response {

	private String fullName;
	private int age;

	public Response(Map<String, Object> input) {
		this.setFullName((String) input.get("firstName") + " " + (String) input.get("lastName"));
		Date currentDate = new Date();
		this.setAge((currentDate.getYear() - ((int) input.get("yearOfBirth")))); 
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
