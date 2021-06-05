package com.serverless;

import java.util.Date;

public class Response {

	private String fullName;
	private int age;

	public Response(String firstName, String lastName, int yearOfBirth) {
		this.setFullName(firstName + " " + lastName);
		int currentYear = new Date().getYear() + 1900;
		this.setAge(currentYear - yearOfBirth); 
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
