package com.tns.webapp.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidItemValidator.class)
public @interface ValidItem {
	String message() default "{com.tns.webapp.validation.constraints.ValidItem.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Country country() default Country.US;

	public enum Country {
		US,
		CANADA,
		MEXICO,
		BRASIL
	}
}
