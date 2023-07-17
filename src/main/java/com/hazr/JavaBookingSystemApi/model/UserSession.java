package com.hazr.JavaBookingSystemApi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_session")
public class UserSession {

    @Id
    private UUID sessionID;


    @Column(name = "expiry_time")
    private LocalDateTime expiryTime;

    @Column(name = "userID")
    private long userID;

    @Column(name = "user_type")
    private UserType userType;

    @Column(name = "csrf_token")
    private UUID csrfToken;


    protected UserSession() {

    }

    public UserSession(LocalDateTime expiryTime, long userID, UserType userType) {
        this.sessionID = UUID.randomUUID();
        this.expiryTime = expiryTime;
        this.userID = userID;
        this.userType = userType;
        this.csrfToken = UUID.randomUUID();
    }

    public UUID getSessionID() {
        return sessionID;
    }

    public void setSessionID(UUID sessionID) {
        this.sessionID = sessionID;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public long getUserID() {
        return userID;
    }

    public void setUser(long userID) {
        this.userID = userID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UUID getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(UUID csrfToken) {
        this.csrfToken = csrfToken;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "sessionID=" + sessionID +
                ", expiryTime=" + expiryTime +
                ", userID=" + userID +
                ", userType=" + userType +
                ", csrfToken=" + csrfToken +
                '}';
    }
}
