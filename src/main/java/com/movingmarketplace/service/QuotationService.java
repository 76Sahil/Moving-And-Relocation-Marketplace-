package com.movingmarketplace.service;

import com.movingmarketplace.dto.QuotationRequestDTO;
import com.movingmarketplace.dto.QuotationResponseDTO;
import com.movingmarketplace.entity.MovingRequest;
import com.movingmarketplace.entity.Quotation;
import com.movingmarketplace.repository.MovingRequestRepository;
import com.movingmarketplace.repository.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;
    private final MovingRequestRepository movingRequestRepository;

    public QuotationService(
            QuotationRepository quotationRepository,
            MovingRequestRepository movingRequestRepository
    ) {
        this.quotationRepository = quotationRepository;
        this.movingRequestRepository = movingRequestRepository;
    }

    public QuotationResponseDTO createQuotation(QuotationRequestDTO request) {

        MovingRequest movingRequest = movingRequestRepository
                .findById(request.getMovingRequestId())
                .orElseThrow(() ->
                        new RuntimeException("Moving request not found"));

        Quotation quotation = new Quotation(
                movingRequest,
                request.getAmount(),
                request.getStatus()
        );

        Quotation savedQuotation = quotationRepository.save(quotation);

        return toResponseDTO(savedQuotation);
    }

    public List<QuotationResponseDTO> getAllQuotations() {

        return quotationRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public QuotationResponseDTO getQuotationById(Long id) {

        Quotation quotation = quotationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Quotation not found"));

        return toResponseDTO(quotation);
    }

    public void deleteQuotation(Long id) {

        if (!quotationRepository.existsById(id)) {
            throw new RuntimeException("Quotation not found");
        }

        quotationRepository.deleteById(id);
    }

    private QuotationResponseDTO toResponseDTO(Quotation quotation) {

        return new QuotationResponseDTO(
                quotation.getId(),
                quotation.getMovingRequest().getId(),
                quotation.getAmount(),
                quotation.getStatus()
        );
    }
}