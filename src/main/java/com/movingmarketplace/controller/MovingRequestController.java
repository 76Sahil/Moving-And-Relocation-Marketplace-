package com.movingmarketplace.controller;

import com.movingmarketplace.entity.MovingRequest;
import com.movingmarketplace.service.MovingRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moving-requests")
public class MovingRequestController {

    private final MovingRequestService movingRequestService;

    public MovingRequestController(
            MovingRequestService movingRequestService
    ) {
        this.movingRequestService = movingRequestService;
    }

    @PostMapping
    public ResponseEntity<MovingRequest> createMovingRequest(
            @Valid @RequestBody MovingRequest movingRequest
    ) {
        MovingRequest createdRequest =
                movingRequestService.createMovingRequest(movingRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdRequest);
    }

    @GetMapping
    public ResponseEntity<List<MovingRequest>> getAllMovingRequests() {
        return ResponseEntity.ok(
                movingRequestService.getAllMovingRequests()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovingRequest> getMovingRequestById(
            @PathVariable Long id
    ) {
        return movingRequestService
                .getMovingRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovingRequest> updateMovingRequest(
            @PathVariable Long id,
            @Valid @RequestBody MovingRequest movingRequest
    ) {
        return movingRequestService
                .updateMovingRequest(id, movingRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovingRequest(
            @PathVariable Long id
    ) {
        boolean deleted = movingRequestService.deleteMovingRequest(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}