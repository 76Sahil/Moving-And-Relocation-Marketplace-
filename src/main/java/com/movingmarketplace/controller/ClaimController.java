package com.movingmarketplace.controller;

import com.movingmarketplace.dto.ClaimRequestDTO;
import com.movingmarketplace.dto.ClaimResponseDTO;
import com.movingmarketplace.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ResponseEntity<ClaimResponseDTO> createClaim(
            @Valid @RequestBody ClaimRequestDTO request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(claimService.createClaim(request));
    }

    @GetMapping
    public ResponseEntity<List<ClaimResponseDTO>> getAllClaims() {

        return ResponseEntity.ok(
                claimService.getAllClaims()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimResponseDTO> getClaimById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                claimService.getClaimById(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(
            @PathVariable Long id) {

        claimService.deleteClaim(id);

        return ResponseEntity.noContent().build();
    }
}