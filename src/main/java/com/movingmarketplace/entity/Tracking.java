package com.movingmarketplace.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tracking")
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "moving_request_id", nullable = false)
    private MovingRequest movingRequest;

    @Column(nullable = false)
    private String status;

    private String currentLocation;

    private LocalDateTime lastUpdated;

    public Tracking() {
    }

    public Tracking(Long id, MovingRequest movingRequest, String status,
                    String currentLocation, LocalDateTime lastUpdated) {
        this.id = id;
        this.movingRequest = movingRequest;
        this.status = status;
        this.currentLocation = currentLocation;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovingRequest getMovingRequest() {
        return movingRequest;
    }

    public void setMovingRequest(MovingRequest movingRequest) {
        this.movingRequest = movingRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}