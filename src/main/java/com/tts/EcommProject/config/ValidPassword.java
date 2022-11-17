package com.tts.EcommProject.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
	
	 String message() default "Invalid Password";

	     Class<?>[] groups() default {};
	     Class<? extends Payload>[] payload() default {};

}


	

