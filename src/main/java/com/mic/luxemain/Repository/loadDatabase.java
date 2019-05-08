package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.DailyMeal;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.MenuType;
import com.mic.luxemain.domain.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class loadDatabase {

    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    MenuTypeRepository menuTypeRepository;

    @Autowired
    DailyMealRepository dailyMealRepository;

    @Autowired
    ReservationRepository reservationRepository;






    @Bean
    CommandLineRunner loader(){
        return args -> {
            //This is for loading the menu type
            MenuType itemStart = new MenuType("Staters");
            MenuType itemBar = new MenuType("Bar");
            MenuType itemMain = new MenuType("Main");
            menuTypeRepository.save(itemStart);
            menuTypeRepository.save(itemBar);
            menuTypeRepository.save(itemMain);


            //this is for loading the menu item
            MenuItem Starter1 = new MenuItem("Starter1" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg" , true , 2500 , itemStart);
            MenuItem Starter2 = new MenuItem("Starter2" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemStart);
            MenuItem Starter3 = new MenuItem("Starter3" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemStart);

            menuItemRepository.save(Starter1);
            menuItemRepository.save(Starter2);
            menuItemRepository.save(Starter3);



            //[] saving Bar
            MenuItem Bar1 = new MenuItem("Bar1" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemBar);
            MenuItem Bar2 = new MenuItem("Bar1" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemBar);

            MenuItem Bar3 = new MenuItem("Bar1" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 ,itemBar);

            menuItemRepository.save(Bar1);
            menuItemRepository.save(Bar2);
            menuItemRepository.save(Bar3);


            //[] saving main
            MenuItem Manin1 = new MenuItem("Manin1" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemMain);

            MenuItem Manin2 = new MenuItem("Manin2" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemMain);

            MenuItem Manin3 = new MenuItem("Manin3" , "the beast" ,
                    "https://cdn.jamieoliver.com/home/wp-content/uploads/features-import/2015/04/taglierini_with_a_simple_tomato_sauce.jpg"
                    , true , 2500 , itemMain);


            menuItemRepository.save(Manin1);
            menuItemRepository.save(Manin2);
            menuItemRepository.save(Manin3);



            //loading the daily meal
           log.info( "LOded" + dailyMealRepository.save( new DailyMeal("Monday" , 250 , Manin3  )) );
           log.info("Loaded" + dailyMealRepository.save( new DailyMeal("Tuesday" , 25 , Manin3  )) );


           //reservarion
            log.info("Loaded" + reservationRepository.save( new
                    Reservation("jack" , "Bougle" , "2019-05-11" , 5 , "michael@gmail.com")  ));

            log.info("Loaded" + reservationRepository.save( new
                    Reservation("Michael" , "reid" , "2019-05-10" , 8 , "michael@gmial.com")  ));





        };

    }
}
