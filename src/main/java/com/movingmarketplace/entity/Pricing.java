package com.movingmarketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;



@Entity
@Table(name = "pricing")
public class Pricing
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "moving_request_id",nullable = false, unique = true)
    private MovingRequest movingRequest;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(nullable = false)
    private BigDecimal basePrice;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(nullable = false)
    private BigDecimal additionalCharges;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(nullable = false)
    private BigDecimal totalPrice;

    public Pricing()
    {}

    public Pricing(MovingRequest movingRequest,
                   BigDecimal basePrice,
                   BigDecimal additionalCharges,
                   BigDecimal totalPrice) {
        this.movingRequest = movingRequest;
        this.basePrice = basePrice;
        this.additionalCharges = additionalCharges;
        this.totalPrice = totalPrice;
    }
    public MovingRequest getMovingRequest() {
        return movingRequest;
    }

    public void setMovingRequest(MovingRequest movingRequest) {
        this.movingRequest = movingRequest;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(BigDecimal additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}