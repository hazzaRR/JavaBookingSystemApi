package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.Entity;

@Entity
public class Employee extends MainUser {


    protected Employee() {

    }
    public Employee(long id, String password, String email, String firstname, String surname, String telephone) {
        super(id, password, email, firstname, surname, telephone);
    }

}
