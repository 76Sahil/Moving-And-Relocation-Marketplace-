package com.movingmarketplace.controller;

import com.movingmarketplace.entity.Pricing;
import com.movingmarketplace.service.PricingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping
    public ResponseEntity<Pricing> createPricing(
            @RequestParam Long movingRequestId,
            @RequestParam BigDecimal basePrice,
            @RequestParam BigDecimal additionalCharges) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pricingService.createPricing(
                        movingRequestId,
                        basePrice,
                        additionalCharges
                ));
    }

    @GetMapping
    public ResponseEntity<List<Pricing>> getAllPricing() {
        return ResponseEntity.ok(pricingService.getAllPricing());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pricing> getPricingById(@PathVariable Long id) {
        return ResponseEntity.ok(pricingService.getPricingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePricing(@PathVariable Long id) {
        pricingService.deletePricing(id);
        return ResponseEntity.noContent().build();
    }
}