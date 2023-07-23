package com.hazr.JavaBookingSystemApi.repository.repository;

import com.hazr.JavaBookingSystemApi.model.Admin;
import com.hazr.JavaBookingSystemApi.repository.AdminRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AdminRepositoryTest {

    @Autowired
    private AdminRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByUsername() {

        //given

        Admin admin = new Admin("password", "user123");

        underTest.save(admin);

        //when

        Optional<Admin> result = underTest.findByUsername(admin.getUsername());

        //then

        assertThat(result).contains(admin);
    }

    @Test
     void findByUsernameThatDoesNotExist() {

        //given

        String username = "user123";

        //when

        Optional<Admin> result = underTest.findByUsername(username);

        //then

        assertThat(result).isEmpty();

    }

}