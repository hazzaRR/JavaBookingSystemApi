package com.hazr.JavaBookingSystemApi.repository;

import com.hazr.JavaBookingSystemApi.model.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {
}
