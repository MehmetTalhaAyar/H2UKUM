package com.H2UKUM.Hukum.Exceptions.Validations;

import com.H2UKUM.Hukum.DataAccess.UserRepository;
import com.H2UKUM.Hukum.Exceptions.Annotations.UniqueUsername;
import com.H2UKUM.Hukum.Models.User;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator  implements ConstraintValidator<UniqueUsername,String>  {

    UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User inDB = userRepository.findByUsername(value);

        return inDB == null;
    }
    
}
