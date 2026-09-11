package com.movingmarketplace.service;

import com.movingmarketplace.entity.Tracking;
import com.movingmarketplace.repository.TrackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    private final TrackingRepository trackingRepository;

    public TrackingService(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    public Tracking createTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    public Tracking getTrackingById(Long id) {
        return trackingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tracking not found"));
    }

    public List<Tracking> getAllTracking() {
        return trackingRepository.findAll();
    }

    public Tracking updateTracking(Long id, Tracking tracking) {
        Tracking existingTracking = getTrackingById(id);

        existingTracking.setStatus(tracking.getStatus());
        existingTracking.setCurrentLocation(tracking.getCurrentLocation());

        return trackingRepository.save(existingTracking);
    }

    public void deleteTracking(Long id) {
        trackingRepository.deleteById(id);
    }
}