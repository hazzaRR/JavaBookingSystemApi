package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.model.EmployeeAvailability;
import com.hazr.JavaBookingSystemApi.repository.EmployeeAvailabilityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAvailabilityService {

    private EmployeeAvailabilityRepository employeeAvailabilityRepository;

    public EmployeeAvailabilityService(EmployeeAvailabilityRepository employeeAvailabilityRepository) {
        this.employeeAvailabilityRepository = employeeAvailabilityRepository;
    }
}
