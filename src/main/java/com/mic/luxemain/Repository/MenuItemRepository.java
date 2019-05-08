package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.MenuItem;
import com.mic.luxemain.domain.MenuType;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends CrudRepository<MenuItem , Long> {

    List<MenuItem> findAllByActive(boolean active);

    List<MenuItem> findAllByNameIgnoreCase(String name);

    List<MenuItem> findAllByMenuType(MenuType menuType);


    Iterable<MenuItem> findAll(Sort sort);
}
