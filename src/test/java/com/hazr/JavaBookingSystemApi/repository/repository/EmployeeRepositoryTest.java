package com.hazr.JavaBookingSystemApi.repository.repository;

import com.hazr.JavaBookingSystemApi.model.Employee;
import com.hazr.JavaBookingSystemApi.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void FindByEmail() {
        //given
        Employee employee = new Employee("password123", "test@email.com", "Harry", "Redman", "07456 123453");
        underTest.save(employee);
        //when

        Optional<Employee> result = underTest.findByEmail(employee.getEmail());

        //then

        assertThat(result).contains(employee);

    }

    @Test
    void FindByEmailWhichDoesNotExist() {

        //given
        String email = "test@email.com";


        Optional<Employee> result = underTest.findByEmail(email);

        //then

        assertThat(result).isEmpty();

    }

}