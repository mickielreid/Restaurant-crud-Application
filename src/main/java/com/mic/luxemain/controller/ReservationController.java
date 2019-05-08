package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.ReservationRepository;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.Reservation;
import com.mic.luxemain.service.ReservationService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/res")
@Slf4j
public class ReservationController {

    @Autowired
   ReservationRepository repository;

   @Autowired
    ReservationService service;

    public ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/read")
    String getAllReservations(Model model){
        model.addAttribute("res" , repository.findAll());

        return "res/read";
    }

    @GetMapping("/update/{id}")
    String updateById(@PathVariable(value = "id" , required = true ) long id , Model model ){

        model.addAttribute("id" , id);

        model.addAttribute("reservation" , repository.findById(id));

        return "res/update";
    }//end get update

    @PostMapping("/update/{id}")
    String doingUpdate( @Valid Reservation reservation , BindingResult result ,Model model,
                       @PathVariable(value = "id" , required = true) long id ) throws NotFoundException {



        if (result.hasErrors()){

            //log.error("err" + result);
            return "/res/update";
        }

        service.update(id , reservation);

        return "redirect:/res/read";

    }//end update


    //delting by id
    @GetMapping("/delete/{id}")
    String deleteByType(@PathVariable(value = "id",required = true) long id , Model model){
        repository.deleteById(id);

        return "redirect:/res/read";

    }

    //search by naeme
    @GetMapping("/search")
    String searchByName(@RequestParam(value = "date", defaultValue = "1958-05-11") String date , Model model){

        model.addAttribute("res" , repository.findAllByReservedDateIgnoreCase(date) );

        return "res/read";
    }




}
