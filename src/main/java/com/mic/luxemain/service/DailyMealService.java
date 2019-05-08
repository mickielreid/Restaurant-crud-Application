package com.mic.luxemain.service;

import com.mic.luxemain.Repository.DailyMealRepository;
import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.domain.DailyMeal;
import com.mic.luxemain.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DailyMealService {

    @Autowired
    DailyMealRepository repository;

    @Autowired
    MenuItemRepository menuItemRepository;

    public boolean updateDailyMeal(Long id , DailyMeal meal){
        Optional<DailyMeal> repositoryById = repository.findById(id);

        if(repositoryById.isPresent()){
            repositoryById.get().setDay(meal.getDay());
            repositoryById.get().setSpecialPrice(meal.getSpecialPrice());
        }
        else
            return false;

        repository.save(repositoryById.get());
        return  true;

    }

    public boolean addNewSpecial(long itemId){
        DailyMeal meal = null ;

        Optional<MenuItem> menuItem = menuItemRepository.findById(itemId);

        meal = new DailyMeal("may 21 , 1958" , 5 , menuItem.get());

        repository.save(meal);
        return true;

    }

    //this gets al the daily specical for the current if it is in the list of daily special set for today
    public Iterable<DailyMeal> findByCurrentDay(){
        Iterable<DailyMeal> allDailyMeal = repository.findAll();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDay = formatter.format(LocalDate.now());

        List<DailyMeal> todaySpecial = new LinkedList<>();

        for (DailyMeal m : allDailyMeal){
            if (currentDay.equals(m.getDay())){
                todaySpecial.add(m);
            }
        }

        Iterable<DailyMeal> todaysMeal = todaySpecial;

        return todaysMeal;


    }
}
