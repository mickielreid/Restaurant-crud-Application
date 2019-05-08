package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.service.MenuItemService;
import com.mic.luxemain.service.MenuPageControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        //this is for the headers
        model.addAttribute("name" , typeRepository.findAll());

        model.addAttribute("items" , service.getbyActive(id));

        return "front/frontMenu";
    }
}
