package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.dto.LoginDTO;
import com.hazr.JavaBookingSystemApi.dto.RegistrationDTO;
import com.hazr.JavaBookingSystemApi.exception.AccountDoesNotExistException;
import com.hazr.JavaBookingSystemApi.exception.EmailExistsException;
import com.hazr.JavaBookingSystemApi.exception.PasswordDoesNotMatchException;
import com.hazr.JavaBookingSystemApi.model.Admin;
import com.hazr.JavaBookingSystemApi.model.Customer;
import com.hazr.JavaBookingSystemApi.model.Employee;
import com.hazr.JavaBookingSystemApi.repository.AdminRepository;
import com.hazr.JavaBookingSystemApi.repository.CustomerRepository;
import com.hazr.JavaBookingSystemApi.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private AdminRepository adminRepository;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(AdminRepository adminRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
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


    public void loginUser(LoginDTO loginDTO) {

        Optional<Customer> customerExists = customerRepository.findByEmail(loginDTO.getEmail());
        Optional<Employee> employeeExists = employeeRepository.findByEmail(loginDTO.getEmail());
        Optional<Admin> adminExists = adminRepository.findByUsername(loginDTO.getEmail());

        if (customerExists.isEmpty() && employeeExists.isEmpty() && adminExists.isEmpty()) {
            throw new AccountDoesNotExistException(
                    "There is no account associated with the email: " + loginDTO.getEmail());
        }

        if (customerExists.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), customerExists.get().getPassword())) {
            return;
        }
        else if (employeeExists.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), employeeExists.get().getPassword())) {
            return;
        }
        else if (adminExists.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), adminExists.get().getPassword())) {
            return;
        }
        else {
            throw new PasswordDoesNotMatchException("The given password is incorrect");
        }


    }
}
