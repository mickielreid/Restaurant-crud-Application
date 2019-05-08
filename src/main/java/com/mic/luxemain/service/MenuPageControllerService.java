package com.mic.luxemain.service;


import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuPageControllerService {
    @Autowired
    MenuTypeRepository typeRepository;

    @Autowired
    MenuItemRepository itemRepository;


    public  List<MenuItem>  getbyActive(long id){
        //getting the type accoited with the clicked menuType in the nav nav from
        Optional<MenuType> fetchedMenuType = typeRepository.findById(id);

        //this is getting all the menu item baced on the menutype above
        List<MenuItem> fetchedMenuItem = itemRepository.findAllByMenuType(fetchedMenuType.get());


        List<MenuItem> allActiveMenuItem = new LinkedList<>();

        //if it is active it will be added to the list above
        for(MenuItem i : fetchedMenuItem){
            if(i.isActive()){
                allActiveMenuItem.add(i);
            }
        }


        return allActiveMenuItem;

    }
}
