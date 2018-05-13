package com.tns.webapp.web.auth;

import java.security.Principal;
import java.security.acl.Group;
import java.util.Enumeration;

public class SimpleGroup implements Group {

	private String group;

	public SimpleGroup(String group) {
		this.group = group;
	}

	@Override
	public String getName() {
		return this.group;
	}

	@Override
	public boolean addMember(Principal user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeMember(Principal user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMember(Principal member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enumeration<? extends Principal> members() {
		// TODO Auto-generated method stub
		return null;
	}

}
