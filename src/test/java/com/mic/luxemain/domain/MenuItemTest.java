package com.mic.luxemain.domain;


import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class MenuItemTest {

    Validator validator;

    @Before
    public void before(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        validator = factory.getValidator();
    }

    @Test
    public void nameTest(){
        MenuType menuType = new MenuType("Food");
        MenuItem bar = new MenuItem("kjhj" , "the beast" ,
                "http://google.com" , true , 2500 , menuType);

        bar.setName(null);

        Set<ConstraintViolation<MenuItem>> constraintViolations =
                validator.validate(bar);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MenuItem> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }

    }

    @Test
    public void priceTest(){
        MenuType menuType = new MenuType("Food");
        MenuItem Bar1 = new MenuItem("rice" , "the beast" ,
                "http://google.com" , true , -25 , menuType);


        Set<ConstraintViolation<MenuItem>> constraintViolations =
                validator.validate(Bar1);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MenuItem> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }

        //tested neggative and possitive
    }

    @Test
    public void activeTest(){
        MenuType menuType = new MenuType("Food");
        MenuItem bar = new MenuItem("rice" , "the beast" ,
                "http://google.com" , false , 25 , menuType);



        Set<ConstraintViolation<MenuItem>> constraintViolations =
                validator.validate(bar);

        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MenuItem> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }

        //tested neggative and possitive
    }




}