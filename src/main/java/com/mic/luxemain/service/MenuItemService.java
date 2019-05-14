package com.mic.luxemain.service;

import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    MenuItemRepository repository;

    @Autowired
    MenuTypeRepository menuTypeRepository;



    //this will update a a
    public boolean updateMenuItemById(long id , MenuItem menuItem){
        Optional<MenuItem> currentMenuItem = repository.findById(id);
        MenuItem temporyItem = null;
        if( currentMenuItem.isPresent() ){
           temporyItem = currentMenuItem.get();
        }
        else {
            return false;
        }
        //setting all the propities
        temporyItem.setName(menuItem.getName());
        temporyItem.setDescription(menuItem.getDescription());
        temporyItem.setPrice(menuItem.getPrice());
        temporyItem.setImageUrl(menuItem.getImageUrl());
        temporyItem.setActive(menuItem.isActive());
        //getting and setting menutype
        MenuType temMenuType = menuTypeRepository.findByType(menuItem.getMenuType().getType());
        temporyItem.setMenuType(temMenuType);


        repository.save(temporyItem);
        return true;


    }

    //this will save a new Menu item
    public void saveMenuItem(MenuItem menuItem){
        //[Explan] - if will extract the menutype string and go to repo to get the full class then it will
        //it will be added to a tempoty class to be saved
        MenuType menuType = menuItem.getMenuType();

        MenuType type1 = menuTypeRepository.findByType(menuType.getType());
        if(type1 == null){

        }


        MenuItem toSave = new MenuItem(
                menuItem.getName() , menuItem.getDescription() , menuItem.getImageUrl() , true ,
                menuItem.getPrice() , type1
                );

        repository.save(toSave);
    }

    public HashMap<String , MenuItem> getAllMenuItemsWithHeader(){
        HashMap<String , MenuItem> typeAndItem = new HashMap<>();

        Iterable<MenuItem> allMenuItems = repository.findAll();

        for(MenuItem mi : allMenuItems){
            typeAndItem.put(mi.getMenuType().getType() , mi);
        }

        return typeAndItem;
    }

    public List<MenuItem> findByMenuType(long id){
       // Optional<MenuType> fetchedMenuType = menuTypeRepository.findById(id);
        Optional<MenuType> fetchedMenuType = menuTypeRepository.findById(id);

        List<MenuItem> fetchedMenuItem = repository.findAllByMenuType(fetchedMenuType.get());


        return fetchedMenuItem;
    }

}
