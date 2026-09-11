package com.movingmarketplace.repository;

import com.movingmarketplace.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {

    Optional<Tracking> findByMovingRequestId(Long movingRequestId);
}