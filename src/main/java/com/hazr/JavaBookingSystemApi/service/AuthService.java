package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.dto.LoginDTO;
import com.hazr.JavaBookingSystemApi.dto.RegistrationDTO;
import com.hazr.JavaBookingSystemApi.exception.AccountDoesNotExistException;
import com.hazr.JavaBookingSystemApi.exception.EmailExistsException;
import com.hazr.JavaBookingSystemApi.exception.PasswordDoesNotMatchException;
import com.hazr.JavaBookingSystemApi.model.*;
import com.hazr.JavaBookingSystemApi.repository.AdminRepository;
import com.hazr.JavaBookingSystemApi.repository.CustomerRepository;
import com.hazr.JavaBookingSystemApi.repository.EmployeeRepository;
import com.hazr.JavaBookingSystemApi.repository.UserSessionRepository;
import com.hazr.JavaBookingSystemApi.response.LoginResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private AdminRepository adminRepository;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    private UserSessionRepository userSessionRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(AdminRepository adminRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, UserSessionRepository userSessionRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.userSessionRepository = userSessionRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerCustomer(RegistrationDTO registrationDTO) throws EmailExistsException {

        Optional<Customer> customerEmailExists = customerRepository.findByEmail(registrationDTO.getEmail());
        Optional<Employee> employeeEmailExists = employeeRepository.findByEmail(registrationDTO.getEmail());

        if (customerEmailExists.isPresent() || employeeEmailExists.isPresent()) {
            throw new EmailExistsException(
                    "There is an account with that email address:" + registrationDTO.getEmail());
        }


        Customer customerToRegister = new Customer(passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getEmail(),
                registrationDTO.getFirstname(),
                registrationDTO.getSurname(),
                registrationDTO.getTelephone());

        customerRepository.save(customerToRegister);

    }

    public void registerEmployee(RegistrationDTO registrationDTO) throws EmailExistsException {

        Optional<Customer> customerEmailExists = customerRepository.findByEmail(registrationDTO.getEmail());
        Optional<Employee> employeeEmailExists = employeeRepository.findByEmail(registrationDTO.getEmail());

        if (customerEmailExists.isPresent() || employeeEmailExists.isPresent()) {
            throw new EmailExistsException(
                    "There is an account with that email address:" + registrationDTO.getEmail());
        }


        Employee customerToRegister = new Employee(passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getEmail(),
                registrationDTO.getFirstname(),
                registrationDTO.getSurname(),
                registrationDTO.getTelephone());

        employeeRepository.save(customerToRegister);

    }


    public LoginResponse loginUser(LoginDTO loginDTO) {

        Optional<Customer> customerExists = customerRepository.findByEmail(loginDTO.getEmail());
        Optional<Employee> employeeExists = employeeRepository.findByEmail(loginDTO.getEmail());
        Optional<Admin> adminExists = adminRepository.findByUsername(loginDTO.getEmail());

        if (customerExists.isEmpty() && employeeExists.isEmpty() && adminExists.isEmpty()) {
            throw new AccountDoesNotExistException(
                    "There is no account associated with the email: " + loginDTO.getEmail());
        }

        if (customerExists.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), customerExists.get().getPassword())) {
            return new LoginResponse(UserType.CUSTOMER, customerExists.get().getId());
        }
        else if (employeeExists.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), employeeExists.get().getPassword())) {
            return new LoginResponse(UserType.EMPLOYEE, employeeExists.get().getId());
        }
        else if (adminExists.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), adminExists.get().getPassword())) {
            return new LoginResponse(UserType.ADMIN, adminExists.get().getId());
        }
        else {
            throw new PasswordDoesNotMatchException("The given password is incorrect");
        }


    }

    public void createSession(LoginResponse loginResponse) {

        UserSession newSession = new UserSession(
                LocalDateTime.now().plusHours(2),
                loginResponse.getUserId(),
                loginResponse.getUserType()
        );

        userSessionRepository.save(newSession);
    }
}
