package com.movingmarketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "moving_request_id", nullable = false, unique = true)
    private MovingRequest movingRequest;

    @NotNull
    @OneToOne
    @JoinColumn(name = "quotation_id", nullable = false, unique = true)
    private Quotation quotation;

    @NotNull
    @Column(nullable = false)
    private LocalDate bookingDate;

    @NotNull
    @Column(nullable = false)
    private String status;

    public Booking() {
    }

    public Booking(MovingRequest movingRequest,
                   Quotation quotation,
                   LocalDate bookingDate,
                   String status) {
        this.movingRequest = movingRequest;
        this.quotation = quotation;
        this.bookingDate = bookingDate;
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

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}