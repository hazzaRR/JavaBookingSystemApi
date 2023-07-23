package com.hazr.JavaBookingSystemApi.controller;

import com.hazr.JavaBookingSystemApi.dto.RegistrationDTO;
import com.hazr.JavaBookingSystemApi.dto.LoginDTO;
import com.hazr.JavaBookingSystemApi.exception.EmailExistsException;
import com.hazr.JavaBookingSystemApi.service.AuthService;
import com.hazr.JavaBookingSystemApi.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/auth")
@CrossOrigin("*")
class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/test")
    public String registerTest() {
        return "this is a test endpoint";
    }

    @PostMapping("/register-customer")
    public void registerCustomer(@RequestBody RegistrationDTO registrationDTO) {

        try {
            authService.registerCustomer(registrationDTO);

        } catch (EmailExistsException e) {
        System.out.println(e);
        }
    }

    @PostMapping("/register-Employee")
    public void registerEmployee(@RequestBody RegistrationDTO registrationDTO) {

        try {
            authService.registerEmployee(registrationDTO);

        } catch (EmailExistsException e) {
            System.out.println(e);
        }
    }

    @PostMapping("login")
    public void login(@RequestBody LoginDTO LoginDTO) {

    }

}

