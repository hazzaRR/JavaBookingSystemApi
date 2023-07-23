package com.hazr.JavaBookingSystemApi.repository;

import com.hazr.JavaBookingSystemApi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT * FROM Admin a WHERE username = ?1", nativeQuery = true)
    public Optional<Admin> findByUsername(String username);
}
