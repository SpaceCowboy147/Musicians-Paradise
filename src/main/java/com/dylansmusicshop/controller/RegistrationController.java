package com.dylansmusicshop.controller;

import com.dylansmusicshop.users.Users;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class RegistrationController {
    @GetMapping("/")
    public String registrationPage (WebRequest request, Model model) {
        Users user = new Users();
       model.addAttribute("user", user);
        return "registration";
    }

    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid Users user,
                                            HttpServletRequest request, Errors errors) {

        return registerUserAccount(user, request, errors);
    }
    @Target({TYPE, FIELD, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Constraint(validatedBy = EmailValidator.class)
    @Documented
    public @interface ValidEmail {
        String message() default "Invalid email";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
    @Target({TYPE,ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Constraint(validatedBy = PasswordMatchesValidation.class)
    @Documented
    public @interface PasswordMatches {
        String message() default "Passwords don't match";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
    public class PasswordMatchValidation implements ConstraintValidator<RegistrationController.PasswordMatches, Object> {

        @Override
        public void initialize(RegistrationController.PasswordMatches constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
            return false;
        }
    }
}
