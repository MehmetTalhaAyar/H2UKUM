package com.H2UKUM.Hukum.Exceptions.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.H2UKUM.Hukum.Exceptions.Validations.UniqueUsernameValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = {UniqueUsernameValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {

    String message() default "Username in use!";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
