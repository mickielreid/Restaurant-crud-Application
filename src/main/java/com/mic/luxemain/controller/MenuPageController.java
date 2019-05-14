package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.service.MenuItemService;
import com.mic.luxemain.service.MenuPageControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;

@Controller
public class MenuPageController {


    MenuTypeRepository typeRepository;

    @Autowired
    MenuPageControllerService service;

    public MenuPageController(MenuTypeRepository typeRepository, MenuItemRepository itemRepository, MenuItemService ItemService) {
        this.typeRepository = typeRepository;

    }


    @GetMapping("/menu")
    public String findSelected(@RequestParam(value = "id") long id , Model model){

        //this will get the first id from the list
        if(id == -50){
            id = typeRepository.findAll().iterator().next().getId();
        }

        //this is for the headers
        model.addAttribute("name" , typeRepository.findAll());

        if (service.getbyActive(id).isEmpty() || service.getbyActive(id).size() == 0){
            throw new NoSuchElementException("Sorry Could Not Find A Menu Item for " + id + " Please follow the buttons");
        }else {


            model.addAttribute("items", service.getbyActive(id));
        }
        return "front/frontMenu";
    }
}
