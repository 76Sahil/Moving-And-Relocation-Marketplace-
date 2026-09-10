package com.movingmarketplace.dto;

import java.math.BigDecimal;

public class ClaimResponseDTO {

    private Long id;
    private Long movingRequestId;
    private String description;
    private BigDecimal claimAmount;
    private String status;

    public ClaimResponseDTO() {
    }

    public ClaimResponseDTO(Long id,
                            Long movingRequestId,
                            String description,
                            BigDecimal claimAmount,
                            String status) {
        this.id = id;
        this.movingRequestId = movingRequestId;
        this.description = description;
        this.claimAmount = claimAmount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getMovingRequestId() {
        return movingRequestId;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
}