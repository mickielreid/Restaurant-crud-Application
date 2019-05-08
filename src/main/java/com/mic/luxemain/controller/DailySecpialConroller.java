package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.DailyMealRepository;
import com.mic.luxemain.domain.DailyMeal;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.service.DailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/daily")
public class DailySecpialConroller {


    DailyMealRepository repository;

    @Autowired
    DailyMealService service;


    public DailySecpialConroller(DailyMealRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/read")
    String findAll(Model model){
        model.addAttribute("daily" , repository.findAll()  );

        return "/special/read";

    }//end find all


    @GetMapping("/update/{id}")
    String updateByIde(@PathVariable(value = "id" , required = true ) long id , Model model ){

        model.addAttribute("id" , id);

        model.addAttribute("daily" , repository.findById(id));

        return "special/update";
    }//end get update

    @PostMapping("/update/{id}")
    String doingUpdate(@Valid DailyMeal dailyMeal ,BindingResult result ,Model model,
                       @PathVariable(value = "id" , required = true) long id ){
        if (result.hasErrors()){
            return "/special/update";
        }

        service.updateDailyMeal(id , dailyMeal);

        model.addAttribute("daily" , repository.findAll()  );


        return "redirect:/daily/read";

    }//end update

    @GetMapping("/delete/{id}")
    String deleteById(@PathVariable(value = "id" , required = true) long id , Model model){

        repository.deleteById(id);
        model.addAttribute("daily" , repository.findAll()  );

        return "redirect:/daily/read";


    }

    //this is called form the Menu Item / read
    @GetMapping("/create/{item-id}")
    String addNewsDailyMeal(@PathVariable( required = true , value = "item-id") long item , Model model){


        service.addNewSpecial(item);


        model.addAttribute("daily" , repository.findAll()  );

        return "redirect:/daily/read";

    }


    //serach by name
    @GetMapping("/search")
    String scearhByName(@RequestParam(value = "day" , required = true) String day , Model model){

        model.addAttribute("daily" , repository.findAllByDay(day)  );

        return "special/read";
    }



}
