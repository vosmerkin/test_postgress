package com.example.postgres.validator;

import com.example.postgres.controllers.NamesCrudController;
import com.example.postgres.entity.Name;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@Component("beforeCreateNamesValidator")
public class NamesValidator implements Validator {

    private static final Logger log = LoggerFactory.getLogger(NamesValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return Name.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.info("Validation {target}");
        Name name = (Name) target;
        if (checkInputString(name.getName())) {

            errors.rejectValue("name", "name.empty");
        }
        if (checkInputInteger(name.getId())) {
            errors.rejectValue("id", "id.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }

    private boolean checkInputInteger(Integer input) {
        return (input == null);
    }
}
