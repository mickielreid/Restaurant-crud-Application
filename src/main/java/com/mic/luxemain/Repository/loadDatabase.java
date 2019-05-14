package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Autowired
    AdminRepository adminRepository;






    @Bean
    CommandLineRunner loader(PasswordEncoder passwordEncoder){
        return args -> {
            //This is for loading the menu type
            MenuType itemStart = new MenuType("Starters");
            MenuType itemBar = new MenuType("Bar");
            MenuType itemMain = new MenuType("Main");
            menuTypeRepository.save(itemStart);
            menuTypeRepository.save(itemBar);
            menuTypeRepository.save(itemMain);


            //this is for loading the menu item
            MenuItem Starter1 = new MenuItem("Celeriac + Goat Cheese" , "slow baked celeriac, caramelized goat cheese custard, sour apple, burnt onion lavosh, black walnuts + variations of celeriac " ,
                    "https://farm8.staticflickr.com/7321/15933856193_1abb56a57a_z.jpg" ,
                    true , 20 , itemStart);

            MenuItem Starter2 = new MenuItem("Ontario Burrata" , "birch pickled cucumbers, toasted seaweeds, squid ink lavash, prairie seeds + grains" ,
                    "https://pbs.twimg.com/media/BtL0hqkCMAE7Y-b.png"
                    , true , 23 , itemStart);

            MenuItem Starter3 = new MenuItem("Coastal Half Dozen Oysters" , "54 smoker + Ontario Sake mignonette " ,
                    "https://cdn.newsday.com/polopoly_fs/1.20908740.1536714405!/httpImage/image.jpg_gen/derivatives/landscape_768/image.jpg"
                    , true , 22 , itemStart);

            menuItemRepository.save(Starter1);
            menuItemRepository.save(Starter2);
            menuItemRepository.save(Starter3);



            //[] saving Bar
            MenuItem Bar1 = new MenuItem("Australia Day cocktails" , "L-R: watermelon spritz, strawberry sour spritz, Seoul sling, the cool green" ,
                    "https://img.delicious.com.au/F_C2-w6_/w759-h506-cfill/del/2015/11/summer-cocktails-24374-3.jpg"
                    , true , 12 , itemBar);
            MenuItem Bar2 = new MenuItem("Screaming Eagle Cabernet 1992" , "its value can be attributed to its origins in the Napa Valley, which is one of the best-regarded wine-producing region of the New World" ,
                    "https://moneyinc.com/wp-content/uploads/2018/09/Screaming-Eagle-Cabernet-1992.jpg"
                    , true , 1500 , itemBar);

            MenuItem Bar3 = new MenuItem("screech manhattan" , "this cocktail goes down smooth, so you don’t need the tolerance of a sailor to enjoy this feisty libation" ,
                    "https://www.canoerestaurant.com/wp-content/uploads/sites/23/2016/05/canoe-screech-manhattan-1.jpg"
                    , true , 30 ,itemBar);

            menuItemRepository.save(Bar1);
            menuItemRepository.save(Bar2);
            menuItemRepository.save(Bar3);


            //[] saving main
            MenuItem Manin1 = new MenuItem("Tamarack Lamb" , "spring legumes, poached pearl onions, roasted baby gem, shepherd’s pie + lamb jus" ,
                    "https://resizer.otstatic.com/v2/photos/large/24387499.jpg"
                    , true , 23 , itemMain);

            MenuItem Manin2 = new MenuItem("Risoni Risotto" , "salt baked kohlrabi, crisp local greens, Parmesan cream, whipped ricotta, zucchini" ,
                    "https://img.taste.com.au/P-JI1kZE/w643-h428-cfill-q90/taste/2018/06/one-pot-risoni-risotto-with-pancetta-and-zucchini-138388-1.jpg"
                    , true , 39 , itemMain);

            MenuItem Manin3 = new MenuItem("Tea Smoked Duck" , "pan roasted breast, burnt onion cavatelli, kabocha pumpkin, duck liver mousse" ,
                    "https://honest-food.net/wp-content/uploads/2017/12/tea-smoked-duck.jpg"
                    , true , 47 , itemMain);


            menuItemRepository.save(Manin1);
            menuItemRepository.save(Manin2);
            menuItemRepository.save(Manin3);



            //loading the daily meal
           log.info( "LOded" + dailyMealRepository.save( new DailyMeal("2019-05-11" , 250 , Manin3  )) );
           log.info("Loaded" + dailyMealRepository.save( new DailyMeal("2019-05-11" , 25 , Manin3  )) );


           //reservarion
            log.info("Loaded" + reservationRepository.save( new
                    Reservation("jack" , "Bougle" , "2019-05-11" , 5 , "michael@gmail.com")  ));

            log.info("Loaded" + reservationRepository.save( new
                    Reservation("Michael" , "reid" , "2019-05-10" , 8 , "michael@gmial.com")  ));


            log.warn("Admin Added" + adminRepository.save(new Admin(
                    "Michael" , "Reid" , "mike" , passwordEncoder.encode("mike123")
            )));


        };

    }
}
