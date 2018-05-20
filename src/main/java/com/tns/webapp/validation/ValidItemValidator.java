package com.tns.webapp.validation;

import java.util.Objects;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

import com.tns.webapp.domain.Item;

public class ValidItemValidator implements ConstraintValidator<ValidItem, Item> {

    @Inject
    @KSession("ksession1")
    KieSession kSession;

	@Override
	public void initialize(ValidItem constraintAnnotation) {

	}

	@Override
	public boolean isValid(Item value, ConstraintValidatorContext context) {
		if (Objects.isNull(value)) {
			return true;
		}

		kSession.insert(value);
		int result = kSession.fireAllRules();

		return false;
	}

}
