package com.mic.luxemain.domain;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.*;

public class MenuTypeTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory val = Validation.buildDefaultValidatorFactory();
        validator = val.getValidator();
    }

    @Test
    public void MenuTypeTest(){
        MenuType menuType = new MenuType(null);


        Set<ConstraintViolation<MenuType>> constraintViolations =
                validator.validate( menuType );

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MenuType> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }

    @Test
    public void  EmtyTest(){
        MenuType menuType = new MenuType("");


        Set<ConstraintViolation<MenuType>> constraintViolations =
                validator.validate( menuType );

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MenuType> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }

    @Test
    public void  correntTest(){
        MenuType menuType = new MenuType("should work");


        Set<ConstraintViolation<MenuType>> constraintViolations =
                validator.validate( menuType );

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MenuType> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }

}