package com.tns.webapp.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

@Stateless
public class RuleServiceImpl implements RuleService {

    @Inject
    @KSession("ksession1")
    KieSession kSession;

	@Override
	public void execute() {

		kSession.fireAllRules();

	}

}
