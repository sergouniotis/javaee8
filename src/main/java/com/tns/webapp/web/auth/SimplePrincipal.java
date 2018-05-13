package com.tns.webapp.web.auth;

import java.security.Principal;

public class SimplePrincipal implements Principal {

	private String name;

	public SimplePrincipal(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
