package com.mic.luxemain.service;

import com.mic.luxemain.Repository.DailyMealRepository;
import com.mic.luxemain.domain.DailyMeal;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.MenuType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DailyMealServiceTest {

    @Mock
    DailyMealRepository repository;

    @InjectMocks
    DailyMealService service;

    @Test
    public void findByCurrentDay() {
        MenuType itemStart = new MenuType("Staters");

        MenuItem Starter1 = new MenuItem("Starter1" , "the beast" ,
                "http://google.com" , true , 2500 , itemStart);


      DailyMeal day1 = new DailyMeal("2019-05-06" , 250 , Starter1  );
      DailyMeal day2 = new DailyMeal("2019-05-06" , 250 , Starter1  );
      DailyMeal day3 =  new DailyMeal("2019-05-18" , 250 , Starter1  );


      Iterable<DailyMeal> allDailyMeal =  Arrays.asList(day1, day2 , day3);


      when(repository.findAll())
              .thenReturn(allDailyMeal);


      for(DailyMeal d : service.findByCurrentDay()){
          System.out.println(d);
      }


    }
}