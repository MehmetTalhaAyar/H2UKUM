package com.H2UKUM.Hukum.Exceptions.Validations;




import com.H2UKUM.Hukum.DataAccess.UserRepository;
import com.H2UKUM.Hukum.Exceptions.Annotations.UniqueEmail;
import com.H2UKUM.Hukum.Models.User;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

    UserRepository userRepository;

    UniqueEmailValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        User inDB = userRepository.findByEmail(value);
        
        return inDB == null;
    }
    
}
