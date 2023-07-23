package com.hazr.JavaBookingSystemApi.repository.repository;

import com.hazr.JavaBookingSystemApi.model.Customer;
import com.hazr.JavaBookingSystemApi.model.Employee;
import com.hazr.JavaBookingSystemApi.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findByEmail() {

        //given

        Customer customer = new Customer("testpassword", "test@email.com", "Harry", "Redman", "07450 380222");
        underTest.save(customer);


        //when

        Optional<Customer> result = underTest.findByEmail(customer.getEmail());

        //then

        assertThat(result).contains(customer);
    }

    @Test
    void findByEmailThatDoesNotExist() {

        //given
        String email = "test@email.com";


        Optional<Customer> result = underTest.findByEmail(email);

        //then

        Assertions.assertThat(result).isEmpty();
    }

}