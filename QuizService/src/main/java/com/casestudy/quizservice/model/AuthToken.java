package com.casestudy.quizservice.model;

public class AuthToken {
	private String token;
	private String username;
	private long id;

	public AuthToken() {

	}

	public AuthToken(String token, String username, long id) {
		this.token = token;
		this.username = username;
		this.id = id;
	}

	public AuthToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
