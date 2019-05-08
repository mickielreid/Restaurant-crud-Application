package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MenuTypeRepository  extends CrudRepository<MenuType, Long> {


    MenuType findByType(String type);




}
