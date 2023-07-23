package com.hazr.JavaBookingSystemApi.repository;

import com.hazr.JavaBookingSystemApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT * FROM Employee e WHERE e.email = ?1", nativeQuery = true)
    public Optional<Employee> findByEmail(String email);
}
