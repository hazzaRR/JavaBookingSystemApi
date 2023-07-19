package com.hazr.JavaBookingSystemApi.service;

import com.hazr.JavaBookingSystemApi.repository.UserSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService {

    private UserSessionRepository userSessionRepository;

    public UserSessionService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }
}
