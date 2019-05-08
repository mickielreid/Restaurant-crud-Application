package com.mic.luxemain.service;

import com.mic.luxemain.Repository.MenuItemRepository;
import com.mic.luxemain.Repository.MenuTypeRepository;
import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.MenuType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuPageControllerServiceTest {

    @Mock
    MenuTypeRepository typeRepository;

    @Mock
    MenuItemRepository itemRepository;


    @InjectMocks
    MenuPageControllerService service;

    @Test
    public void getbyActive() {
        MenuType itemBeverage = new MenuType("Beverage");
        itemBeverage.setId(1L);

        MenuType dessert = new MenuType("Milk");
        dessert.setId(2L);

        MenuItem rice = new MenuItem("fromTest" , "the beast" ,
                "http://google.com" , true , 2500 , itemBeverage);
        rice.setId(1L);

        MenuItem beans = new MenuItem("beans and no rice" , "the beast" ,
                "http://google.com" , true , 2500 , itemBeverage);
        beans.setId(2L);

        MenuItem ice = new MenuItem("Ice Cream" , "the beast" ,
                "http://google.com" , true , 25 , dessert);
        ice.setId(3L);

        List<MenuItem> menuItems =  Arrays.asList( rice , beans ,ice );


        when(typeRepository.findById(1L))
                .thenReturn(Optional.of(itemBeverage));

        when(itemRepository.findAllByMenuType(itemBeverage))
                .thenReturn(menuItems);



        for(MenuItem t : service.getbyActive(1L)){
            System.out.println(t);
        }


    }
}