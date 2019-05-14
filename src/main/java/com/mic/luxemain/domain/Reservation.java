package com.mic.luxemain.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Reservation extends AuditingDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First Name must Present")
    private String firstName;


    @NotEmpty(message = "Last Name must Present")
    private String lastName;


    @NotEmpty(message = "Date must Present")
    private String reservedDate;

    @Min(value = 1 , message = "Please Include at least one guest including your self")
    @Max(value = 20 , message = "Sorry our largest table can hold a maxinum of 20 people")
    private int guests;


    @NotEmpty(message = "we need your email to confim your request")
    @Email(message = "we need your email to confim your request")
    private String email;

    public Reservation(String firstName, String lastName, String reservedDate, int guests, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservedDate = reservedDate;
        this.guests = guests;
        this.email = email;
    }

    public Reservation(){}

}
