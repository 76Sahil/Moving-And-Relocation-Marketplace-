package com.movingmarketplace.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "moving_requests")
public class MovingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String origin;

    @NotBlank
    @Column(nullable = false)
    private String destination;

    @NotBlank
    @Column(nullable = false)
    private String propertyType;

    @NotNull
    @Column(nullable = false)
    private LocalDate movingDate;

    @NotBlank
    @Column(nullable = false)
    private String serviceNeeds;

    public MovingRequest() {
    }

    public MovingRequest(
            String origin,
            String destination,
            String propertyType,
            LocalDate movingDate,
            String serviceNeeds
    ) {
        this.origin = origin;
        this.destination = destination;
        this.propertyType = propertyType;
        this.movingDate = movingDate;
        this.serviceNeeds = serviceNeeds;
    }

    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public LocalDate getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(LocalDate movingDate) {
        this.movingDate = movingDate;
    }

    public String getServiceNeeds() {
        return serviceNeeds;
    }

    public void setServiceNeeds(String serviceNeeds) {
        this.serviceNeeds = serviceNeeds;
    }
}