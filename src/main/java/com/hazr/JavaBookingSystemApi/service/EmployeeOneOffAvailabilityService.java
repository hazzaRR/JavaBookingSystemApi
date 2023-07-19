package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.repository.EmployeeOneOffAvailabilityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeOneOffAvailabilityService {

    private EmployeeOneOffAvailabilityRepository employeeOneOffAvailabilityRepository;


    public EmployeeOneOffAvailabilityService(EmployeeOneOffAvailabilityRepository employeeOneOffAvailabilityRepository) {
        this.employeeOneOffAvailabilityRepository = employeeOneOffAvailabilityRepository;
    }
}
