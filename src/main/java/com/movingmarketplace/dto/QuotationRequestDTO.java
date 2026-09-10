package com.movingmarketplace.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class QuotationRequestDTO {

    @NotNull(message = "Moving request ID is required")
    private Long movingRequestId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Amount must be greater than or equal to 0")
    private BigDecimal amount;

    @NotNull(message = "Status is required")
    private String status;

    public QuotationRequestDTO() {
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public void setMovingRequestId(Long movingRequestId) {
        this.movingRequestId = movingRequestId;
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