package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.Entity;

@Entity
public class Employee extends MainUser {


    protected Employee() {

    }
    public Employee(String password, String email, String firstname, String surname, String telephone) {
        super(password, email, firstname, surname, telephone);
    }

}
