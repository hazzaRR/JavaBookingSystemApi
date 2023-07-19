package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.repository.EmployeeBlockedDayRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBlockedDayService {

    private EmployeeBlockedDayRepository employeeBlockedDayRepository;

    public EmployeeBlockedDayService(EmployeeBlockedDayRepository employeeBlockedDayRepository) {
        this.employeeBlockedDayRepository = employeeBlockedDayRepository;
    }
}
