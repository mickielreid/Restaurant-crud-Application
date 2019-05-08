package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.ReservationRepository;
import com.mic.luxemain.domain.Reservation;
import com.mic.luxemain.service.DailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GeneralController {
    @Autowired
    DailyMealService dailyMealService;

    @Autowired
    ReservationRepository reservationRepository;



    @GetMapping({"/" , "home" , "index"})
    String Home(){
        return "index.html";
    }

    @GetMapping("/about")
    String about(){
        return "front/about";
    }

    @GetMapping("/daily-special")
    String dailySpecial(Model model){
        model.addAttribute("items" , dailyMealService.findByCurrentDay());
        return "front/special";
    }

    //this section is for create/ add
    @GetMapping("/make-res")
    String  addNewRservation(Model model){

        model.addAttribute("reservation" , new Reservation());

        return "front/make-res";
    }

    @PostMapping("/make-res")
    String addNewType(@Valid Reservation reservation , BindingResult bindingResult , Model model   ){

        if(bindingResult.hasErrors() ){
            return "front/make-res";
        }

        reservationRepository.save(reservation);

        model.addAttribute("res" , reservation);


        return "front/confirm-res";

    }
}
