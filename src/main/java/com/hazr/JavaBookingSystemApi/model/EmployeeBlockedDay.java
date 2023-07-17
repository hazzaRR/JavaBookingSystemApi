package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_blocked_day", uniqueConstraints = { @UniqueConstraint(name = "uniqueBlockedDay", columnNames = { "employeeID", "date"})})
public class EmployeeBlockedDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;

    @Column(name = "date")
    private LocalDate date;


    protected EmployeeBlockedDay() {
    }

    public EmployeeBlockedDay(Employee employee, LocalDate date) {
        this.employee = employee;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmployeeBlockedDay{" +
                "id=" + id +
                ", employee=" + employee +
                ", date=" + date +
                '}';
    }
}
