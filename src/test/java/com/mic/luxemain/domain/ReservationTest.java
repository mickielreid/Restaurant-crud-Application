package com.mic.luxemain.domain;


import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ReservationTest  {

    Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        validator = factory.getValidator();
    }

    @Test
    public void emailTest(){

        Reservation reservation = new   Reservation("jack" , "Bougle" , "2019-05-11" ,
                5 , "mihcaelgmail.com") ;

        Set<ConstraintViolation<Reservation>> constraintViolations=
                validator.validate(reservation);


        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Reservation> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }

    @Test
    public void guestsTest(){

        Reservation reservation = new   Reservation("jack" , "Bougle" , "2019-05-11" ,
                25 , "mihcael@gmail.com") ;

        Set<ConstraintViolation<Reservation>> constraintViolations=
                validator.validate(reservation);


        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Reservation> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
    }



}