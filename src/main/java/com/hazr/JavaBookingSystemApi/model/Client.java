package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.Entity;

@Entity
public class Client extends MainUser {

    protected Client() {

    }
    public Client(long id, String password, String email, String firstname, String surname, String telephone) {
        super(id, password, email, firstname, surname, telephone);
    }
}
