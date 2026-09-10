package com.movingmarketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moving_request_id", nullable = false)
    private MovingRequest movingRequest;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(nullable = false)
    private BigDecimal claimAmount;

    @NotBlank
    @Column(nullable = false)
    private String status;

    // Default constructor
    public Claim() {
    }

    // Parameterized constructor
    public Claim(
            MovingRequest movingRequest,
            String description,
            BigDecimal claimAmount,
            String status) {

        this.movingRequest = movingRequest;
        this.description = description;
        this.claimAmount = claimAmount;
        this.status = status;
    }

    // Getters and Setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}