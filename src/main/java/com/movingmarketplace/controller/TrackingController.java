package com.movingmarketplace.controller;

import com.movingmarketplace.entity.Tracking;
import com.movingmarketplace.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping
    public ResponseEntity<Tracking> createTracking(@RequestBody Tracking tracking) {
        return ResponseEntity.ok(trackingService.createTracking(tracking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tracking> getTrackingById(@PathVariable Long id) {
        return ResponseEntity.ok(trackingService.getTrackingById(id));
    }

    @GetMapping
    public ResponseEntity<List<Tracking>> getAllTracking() {
        return ResponseEntity.ok(trackingService.getAllTracking());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tracking> updateTracking(
            @PathVariable Long id,
            @RequestBody Tracking tracking) {

        return ResponseEntity.ok(trackingService.updateTracking(id, tracking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTracking(@PathVariable Long id) {
        trackingService.deleteTracking(id);
        return ResponseEntity.noContent().build();
    }
}