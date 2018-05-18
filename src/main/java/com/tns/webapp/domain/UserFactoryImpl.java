package com.tns.webapp.domain;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@Stateless
public class UserFactoryImpl implements UserFactory {

	@Resource
	private SessionContext context;

	@Override
	@Produces
	@RequestScoped
	public User createUser() {
		User user = new User();
		user.setUsername(context.getCallerPrincipal().getName());
		return user;
	}

}
