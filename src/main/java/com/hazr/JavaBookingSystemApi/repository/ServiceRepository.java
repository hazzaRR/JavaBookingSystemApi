package com.hazr.JavaBookingSystemApi.repository;

import com.hazr.JavaBookingSystemApi.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
