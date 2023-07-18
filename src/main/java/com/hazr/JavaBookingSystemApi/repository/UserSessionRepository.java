package com.hazr.JavaBookingSystemApi.repository;

import com.hazr.JavaBookingSystemApi.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
}
