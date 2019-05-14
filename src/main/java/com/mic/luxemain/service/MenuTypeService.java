package com.mic.luxemain.service;

import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuType;
import org.springframework.stereotype.Service;

@Service
public class MenuTypeService {

    MenuTypeRepository repository;


    public MenuTypeService(MenuTypeRepository repository) {
        this.repository = repository;
    }


    public void update(long id , MenuType newType){

        MenuType fetchedType = repository.findById(id).get();

        fetchedType.setType(newType.getType());

        repository.save(fetchedType);
    }
}
