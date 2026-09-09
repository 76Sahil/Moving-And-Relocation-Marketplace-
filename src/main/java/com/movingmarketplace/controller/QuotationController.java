package com.movingmarketplace.controller;

import com.movingmarketplace.dto.QuotationRequestDTO;
import com.movingmarketplace.dto.QuotationResponseDTO;
import com.movingmarketplace.service.QuotationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping
    public ResponseEntity<QuotationResponseDTO> createQuotation(
            @Valid @RequestBody QuotationRequestDTO request)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quotationService.createQuotation(request));
    }

    @GetMapping
    public ResponseEntity<List<QuotationResponseDTO>> getAllQuotations() {
        return ResponseEntity.ok(quotationService.getAllQuotations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuotationResponseDTO> getQuotationById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(quotationService.getQuotationById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuotation(
            @PathVariable Long id
    ) {
        quotationService.deleteQuotation(id);
        return ResponseEntity.noContent().build();
    }
}