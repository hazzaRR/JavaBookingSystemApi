package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String serviceName;

    @Column(precision = 6, scale = 2)
    private BigDecimal price;

    private Integer durationMinutes;

    public Service(String serviceName, BigDecimal price, Integer durationMinutes) {
        this.serviceName = serviceName;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}
