package com.mic.luxemain.Repository;

import com.mic.luxemain.domain.DailyMeal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DailyMealRepository extends CrudRepository<DailyMeal , Long> {
    List<DailyMeal> findAllByDay(String day);




}
