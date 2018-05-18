package com.tns.webapp.domain;

import java.io.Serializable;

public class User implements Serializable {

	private String username;

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
