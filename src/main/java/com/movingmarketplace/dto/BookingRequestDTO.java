package com.movingmarketplace.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingRequestDTO {

    @NotNull(message = "Moving request ID is required")
    private Long movingRequestId;

    @NotNull(message = "Quotation ID is required")
    private Long quotationId;

    @NotNull(message = "Booking date is required")
    private LocalDate bookingDate;

    @NotNull(message = "Status is required")
    private String status;

    public BookingRequestDTO() {
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public void setMovingRequestId(Long movingRequestId) {
        this.movingRequestId = movingRequestId;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
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