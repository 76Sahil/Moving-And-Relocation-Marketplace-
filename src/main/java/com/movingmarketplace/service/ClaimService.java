package com.movingmarketplace.service;

import com.movingmarketplace.dto.ClaimRequestDTO;
import com.movingmarketplace.dto.ClaimResponseDTO;
import com.movingmarketplace.entity.Claim;
import com.movingmarketplace.entity.MovingRequest;
import com.movingmarketplace.repository.ClaimRepository;
import com.movingmarketplace.repository.MovingRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final MovingRequestRepository movingRequestRepository;

    public ClaimService(ClaimRepository claimRepository,
                        MovingRequestRepository movingRequestRepository) {
        this.claimRepository = claimRepository;
        this.movingRequestRepository = movingRequestRepository;
    }

    public ClaimResponseDTO createClaim(ClaimRequestDTO request) {

        MovingRequest movingRequest = movingRequestRepository
                .findById(request.getMovingRequestId())
                .orElseThrow(() ->
                        new RuntimeException("Moving request not found"));

        Claim claim = new Claim(
                movingRequest,
                request.getDescription(),
                request.getClaimAmount(),
                request.getStatus()
        );

        Claim savedClaim = claimRepository.save(claim);

        return toResponseDTO(savedClaim);
    }

    public List<ClaimResponseDTO> getAllClaims() {

        return claimRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ClaimResponseDTO getClaimById(Long id) {

        Claim claim = claimRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Claim not found"));

        return toResponseDTO(claim);
    }

    public void deleteClaim(Long id) {

        if (!claimRepository.existsById(id)) {
            throw new RuntimeException("Claim not found");
        }

        claimRepository.deleteById(id);
    }

    private ClaimResponseDTO toResponseDTO(Claim claim) {

        return new ClaimResponseDTO(
                claim.getId(),
                claim.getMovingRequest().getId(),
                claim.getDescription(),
                claim.getClaimAmount(),
                claim.getStatus()
        );
    }
}