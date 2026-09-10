package com.movingmarketplace.service;

import com.movingmarketplace.entity.MovingRequest;
import com.movingmarketplace.entity.Pricing;
import com.movingmarketplace.repository.MovingRequestRepository;
import com.movingmarketplace.repository.PricingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PricingService {

    private final PricingRepository pricingRepository;
    private final MovingRequestRepository movingRequestRepository;

    public PricingService(
            PricingRepository pricingRepository,
            MovingRequestRepository movingRequestRepository
    ) {
        this.pricingRepository = pricingRepository;
        this.movingRequestRepository = movingRequestRepository;
    }

    public Pricing createPricing(
            Long movingRequestId,
            BigDecimal basePrice,
            BigDecimal additionalCharges
    ) {

        MovingRequest movingRequest = movingRequestRepository
                .findById(movingRequestId)
                .orElseThrow(() ->
                        new RuntimeException("Moving request not found"));

        BigDecimal totalPrice = basePrice.add(additionalCharges);

        Pricing pricing = new Pricing(
                movingRequest,
                basePrice,
                additionalCharges,
                totalPrice
        );

        return pricingRepository.save(pricing);
    }

    public List<Pricing> getAllPricing() {
        return pricingRepository.findAll();
    }

    public Pricing getPricingById(Long id) {
        return pricingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pricing not found"));
    }

    public void deletePricing(Long id) {

        if (!pricingRepository.existsById(id)) {
            throw new RuntimeException("Pricing not found");
        }

        pricingRepository.deleteById(id);
    }
}