package com.movingmarketplace.repository;

import com.movingmarketplace.entity.MovingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovingRequestRepository
        extends JpaRepository<MovingRequest, Long> {
}