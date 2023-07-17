package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.Entity;

@Entity
public class Customer extends MainUser {

    protected Customer() {

    }
    public Customer(long id, String password, String email, String firstname, String surname, String telephone) {
        super(id, password, email, firstname, surname, telephone);
    }
}
