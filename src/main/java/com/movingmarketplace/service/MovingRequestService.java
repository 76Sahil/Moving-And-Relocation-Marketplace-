package com.movingmarketplace.service;

import com.movingmarketplace.entity.MovingRequest;
import com.movingmarketplace.repository.MovingRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovingRequestService {

    private final MovingRequestRepository movingRequestRepository;

    public MovingRequestService(MovingRequestRepository movingRequestRepository) {
        this.movingRequestRepository = movingRequestRepository;
    }

    public MovingRequest createMovingRequest(MovingRequest movingRequest) {
        return movingRequestRepository.save(movingRequest);
    }

    public List<MovingRequest> getAllMovingRequests() {
        return movingRequestRepository.findAll();
    }

    public Optional<MovingRequest> getMovingRequestById(Long id) {
        return movingRequestRepository.findById(id);
    }

    public Optional<MovingRequest> updateMovingRequest(
            Long id,
            MovingRequest updatedRequest
    ) {
        return movingRequestRepository.findById(id)
                .map(existingRequest -> {

                    existingRequest.setOrigin(updatedRequest.getOrigin());
                    existingRequest.setDestination(updatedRequest.getDestination());
                    existingRequest.setPropertyType(updatedRequest.getPropertyType());
                    existingRequest.setMovingDate(updatedRequest.getMovingDate());
                    existingRequest.setServiceNeeds(updatedRequest.getServiceNeeds());

                    return movingRequestRepository.save(existingRequest);
                });
    }

    public boolean deleteMovingRequest(Long id) {

        if (!movingRequestRepository.existsById(id)) {
            return false;
        }

        movingRequestRepository.deleteById(id);
        return true;
    }
}