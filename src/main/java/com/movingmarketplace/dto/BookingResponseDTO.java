package com.movingmarketplace.dto;

import java.time.LocalDate;

public class BookingResponseDTO {

    private Long id;
    private Long movingRequestId;
    private Long quotationId;
    private LocalDate bookingDate;
    private String status;

    public BookingResponseDTO() {
    }

    public BookingResponseDTO(Long id,
                              Long movingRequestId,
                              Long quotationId,
                              LocalDate bookingDate,
                              String status) {
        this.id = id;
        this.movingRequestId = movingRequestId;
        this.quotationId = quotationId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }
}