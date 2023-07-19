package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}
