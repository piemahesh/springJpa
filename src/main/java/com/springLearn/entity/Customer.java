package com.springLearn.entity;

public class Customer {

	private String username, email;
	private Integer id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer(String username, String email, Integer id) {

		this.username = username;
		this.email = email;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", email=" + email + ", id=" + id + "]";
	}

}
