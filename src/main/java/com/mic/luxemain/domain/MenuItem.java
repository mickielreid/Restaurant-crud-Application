package com.mic.luxemain.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Entity
public class MenuItem extends AuditingDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @NotEmpty(message = "Name must contain a name")
   // @Min(value = 2 , message = "Name Must be greater that 2 Characters")
    private String name;

    @NotEmpty(message = "Description must contain a Description")
    private String description;

    @NotEmpty(message = "Image must contain a Url")
    private String imageUrl;

    //active determins if the meal should be on the menu

   // @NotEmpty(message = "active must contain a active")
    @NotNull( message = "active must contain a active")
    private boolean active;

    @NotNull(message = "price must contain a price")
    @Min(value = 2)
    private double price = 1;


    @ManyToOne(fetch = FetchType.EAGER , optional = false )
    @JoinColumn(name = "Type" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @NotNull(message = "Type must contain a Type")
    private  MenuType menuType;


    public MenuItem(String name, String description, String imageUrl, boolean active, double price, MenuType menuType) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.active = active;
        this.price = price;
        this.menuType = menuType;
    }

    public MenuItem(){}
}
