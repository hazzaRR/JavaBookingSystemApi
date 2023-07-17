package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "booking", uniqueConstraints = { @UniqueConstraint(name = "uniqueBooking", columnNames = { "employeeID", "booking_date", "start_time", "end_time"})})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeID", nullable = false)
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "serviceID", nullable = false)
    private Service service;

    protected Booking() {
    }

    public Booking(LocalDate bookingDate, LocalTime startTime, LocalTime endTime, Customer customer, Employee employee, Service service) {
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
