package com.movingmarketplace.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ClaimRequestDTO {

    @NotNull(message = "Moving request ID is required")
    private Long movingRequestId;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Claim amount is required")
    @DecimalMin(value = "0.0", inclusive = true,
            message = "Claim amount must be greater than or equal to 0")
    private BigDecimal claimAmount;

    @NotBlank(message = "Status is required")
    private String status;

    public ClaimRequestDTO() {
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public void setMovingRequestId(Long movingRequestId) {
        this.movingRequestId = movingRequestId;
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