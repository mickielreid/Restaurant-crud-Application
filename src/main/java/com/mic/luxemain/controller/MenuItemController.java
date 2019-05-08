package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.service.MenuItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("item")
@Slf4j
public class MenuItemController {

    //this one for list all
   MenuItemRepository repository;

   @Autowired
   MenuItemService menuItemService;

   @Autowired
    MenuTypeRepository menuTypeRepository;

    public MenuItemController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/this")
    String template(){


        return "item/templateIML";

    }//end find all

    @GetMapping("/read")
    String findAll(Model model){
        model.addAttribute("menuitem" , repository.findAll(Sort.by("name").ascending())  );

        return "/item/read";

    }//end find all

    @GetMapping("/update/{id}")
    String updateByType(@PathVariable(value = "id" , required = true ) long id , Model model ){

        model.addAttribute("id" , id);

        model.addAttribute("menuitem" , repository.findById(id));
        //this is for the list of menu types
        model.addAttribute("type" , menuTypeRepository.findAll());

        return "item/update";
    }//end get update

    @PostMapping("/update/{id}")
    String doingUpdate(@Valid MenuItem menuitem,  BindingResult bindingResult ,
                       @PathVariable(value = "id" , required = true) long id , Model model ){

        MenuItem i = menuitem;
        if(bindingResult.hasErrors()){
            //to diaply a option of all menutype


            model.addAttribute("type" , menuTypeRepository.findAll());

            return "item/update";
        }

        menuItemService.updateMenuItemById(id , menuitem);

        //simple logic
        return "redirect:/item/read";

    }//end update


    //this is the delete
    @GetMapping("/delete/{id}")
    String deleteByType(@PathVariable(value = "id",required = true) long id , Model model){
        repository.deleteById(id);


        model.addAttribute("menuitem" , repository.findAll()  );

        return "redirect:/item/read";

    }

    //this section is for create/ add
    @GetMapping("/create")
    String addTYpe(Model model){

        model.addAttribute("menuItem" , new MenuItem());
        model.addAttribute("type" , menuTypeRepository.findAll());

        return "item/create";
    }

    @PostMapping("/create")
    String addNewType(@Valid MenuItem menuitem , BindingResult bindingResult , Model model ){
        MenuItem m = menuitem;
       //log.info("re" + menuItem);
        if(bindingResult.hasErrors()){
            //to diaply a option of all menutype
            model.addAttribute("type" , menuTypeRepository.findAll());
            return "item/create";
        }

        menuItemService.saveMenuItem(menuitem);


        return "redirect:/item/read";

    }


    //search by naeme
    @GetMapping("/search")
    String searchByName(@RequestParam(value = "name", defaultValue = "riceandbeans") String name , Model model){

        model.addAttribute("menuitem" , repository.findAllByNameIgnoreCase(name) );

        return "item/read";
    }


}
