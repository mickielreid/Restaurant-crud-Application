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

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemServiceTest {

    @Mock
    private MenuItemRepository repository;

    @Mock
    private MenuTypeRepository menuTypeRepository;


    @InjectMocks
    private MenuItemService service;




    //@Test
    //call the dependency which is the finad all in service from itemrepo
    public void getAllMenuItemsWithHeaderTest(){
        MenuType itemBeverage = new MenuType("Beverage");

        MenuItem rice = new MenuItem("fromTest" , "the beast" ,
                "http://google.com" , true , 2500 , itemBeverage);
        rice.setId(5L);

        HashMap<String , MenuItem> expectedMap = new HashMap<>();
        expectedMap.put("Beverage" ,rice );

        when(repository.findAll())
                .thenReturn(Arrays.asList(rice));

        HashMap<String , MenuItem> expectedMaptry = service.getAllMenuItemsWithHeader();

        System.out.println(expectedMaptry.get(rice.getMenuType().getType()));

        assertEquals(rice , expectedMaptry.get(rice.getMenuType().getType()));

    }

    @Test
    public void getAllByTypeTest(){
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

        List<MenuItem> menuItems =  Arrays.asList( rice , beans , ice );

        when(menuTypeRepository.findById(2L ))
                .thenReturn(Optional.of(dessert ));


        when(repository.findAllByMenuType(dessert))
                .thenReturn(menuItems);

        for (MenuItem m : service.findByMenuType(2L)){
            System.out.println(m.toString());
        }


        assertEquals(menuItems.get(0), service.findByMenuType(2L).get(0));
    }


}