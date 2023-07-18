package com.hazr.JavaBookingSystemApi.repository;

import com.hazr.JavaBookingSystemApi.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
