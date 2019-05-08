package com.mic.luxemain.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
@Entity
public class MenuType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Menu type cannot be null or empty")
    @NotNull(message = "Menu type cannot be null or empty")
    @Size(min = 2 , max = 100 , message = "size must be at least 5 ")
    private String type;

    public MenuType(@NotEmpty(message = "Menu type cannot be null") String type) {
        this.type = type;
    }


}
