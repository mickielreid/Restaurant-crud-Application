package com.mic.luxemain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;


@ControllerAdvice
@Slf4j
public class MenuPage {

    @ExceptionHandler(value =  {NoSuchElementException.class , Exception.class})
    public ModelAndView noValue(HttpServletRequest req, NoSuchElementException ex , Exception exception){

        log.error("No value for menu type id ");

        ModelAndView model = new ModelAndView();

        model.addObject("msg" , ex.getMessage());

        model.setViewName("exp/menupage");


        return model;
    }
}
