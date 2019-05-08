package com.mic.luxemain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class DailyMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Day must Present")
    private String day;

    @Min(value = 2)
    private double specialPrice;

    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "Menu_Item")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MenuItem menuItem;


    public DailyMeal( String day, double specialPrice, MenuItem menuItem) {
        this.day = day;
        this.specialPrice = specialPrice;
        this.menuItem = menuItem;
    }
}
