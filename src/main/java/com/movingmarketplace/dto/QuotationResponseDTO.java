package com.movingmarketplace.dto;

import java.math.BigDecimal;

public class QuotationResponseDTO {

    private Long id;
    private Long movingRequestId;
    private BigDecimal amount;
    private String status;

    public QuotationResponseDTO() {
    }

    public QuotationResponseDTO(
            Long id,
            Long movingRequestId,
            BigDecimal amount,
            String status
    ) {
        this.id = id;
        this.movingRequestId = movingRequestId;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}