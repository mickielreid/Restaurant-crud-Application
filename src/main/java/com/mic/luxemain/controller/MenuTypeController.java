package com.mic.luxemain.controller;

import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuType;
import com.mic.luxemain.service.MenuTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.control.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/type")
//Menu Type
public class MenuTypeController {

    MenuTypeRepository typeRepository;
    MenuTypeService menuTypeService;

    public MenuTypeController(MenuTypeRepository typeRepository ,  MenuTypeService menuTypeService) {
        this.typeRepository = typeRepository;
        this.menuTypeService = menuTypeService;
    }

    @GetMapping("/list-all")
    String findAll(Model model){
        model.addAttribute("menutype" , typeRepository.findAll()  );

        return "/type/listAll";

    }//end find all


    @GetMapping("/update/{id}")
    String updateByType(@PathVariable(value = "id" , required = true ) long id , Model model ){

        model.addAttribute("id" , id);

         model.addAttribute("menutype" , typeRepository.findById(id));

         return "/type/update";
    }//end get update


    //[] because its one colum in the database , so i take the old valjue and delete it and
    //replace it with the new type in menu service class.
    @PostMapping("edit/{id}")
    String doingUpdate(@Valid MenuType menuType , Model model,  BindingResult result ,
                       @PathVariable(value = "id" , required = true) long id ){
        if (result.hasErrors()){
            return "/type/update";
        }

         menuTypeService.update(id , menuType);

        model.addAttribute("menutype" , typeRepository.findAll());
        return "redirect:/type/list-all";

    }//end update

    //this is the delete
    @GetMapping("/delete/{id}")
    String deleteByType(@PathVariable(value = "id",required = true) long id , Model model){
        typeRepository.deleteById(id);

        model.addAttribute("menutype" , typeRepository.findAll());

        return "redirect:/type/list-all";

    }


    //this section is for create/ add

    @GetMapping("/add-type")
    String  addTYpe(Model model){

        model.addAttribute("menuType" , new MenuType());

        return "type/add-type";
    }

    @PostMapping("/add-type")
    String addNewType(@Valid MenuType menuType , BindingResult result , Model model){
        if(result.hasErrors()){
            return "type/add-type";
        }

        typeRepository.save(menuType);

        model.addAttribute("menutype" , typeRepository.findAll());

        return "redirect:/type/list-all";

    }

}
