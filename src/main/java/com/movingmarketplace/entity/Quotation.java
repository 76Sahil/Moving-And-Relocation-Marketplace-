package com.movingmarketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "quotations")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moving_request_id", nullable = false)
    private MovingRequest movingRequest;                                //Connects the quotation to the customer's moving request

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(nullable = false)
    private BigDecimal amount;                                          //Price quoted for the move

    @Column(nullable = false)
    private String status;                                              //Quotation state such as PENDING, ACCEPTED, REJECTED

    public Quotation() {
    }

    public Quotation(
            MovingRequest movingRequest,
            BigDecimal amount,
            String status
    ) {
        this.movingRequest = movingRequest;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public MovingRequest getMovingRequest() {
        return movingRequest;
    }

    public void setMovingRequest(MovingRequest movingRequest) {
        this.movingRequest = movingRequest;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}