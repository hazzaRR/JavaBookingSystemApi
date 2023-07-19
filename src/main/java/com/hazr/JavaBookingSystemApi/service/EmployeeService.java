package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
