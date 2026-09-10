package com.movingmarketplace.service;

import com.movingmarketplace.dto.BookingRequestDTO;
import com.movingmarketplace.dto.BookingResponseDTO;
import com.movingmarketplace.entity.Booking;
import com.movingmarketplace.entity.MovingRequest;
import com.movingmarketplace.entity.Quotation;
import com.movingmarketplace.repository.BookingRepository;
import com.movingmarketplace.repository.MovingRequestRepository;
import com.movingmarketplace.repository.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MovingRequestRepository movingRequestRepository;
    private final QuotationRepository quotationRepository;

    public BookingService(BookingRepository bookingRepository,
                          MovingRequestRepository movingRequestRepository,
                          QuotationRepository quotationRepository) {
        this.bookingRepository = bookingRepository;
        this.movingRequestRepository = movingRequestRepository;
        this.quotationRepository = quotationRepository;
    }

    public BookingResponseDTO createBooking(BookingRequestDTO request) {

        MovingRequest movingRequest = movingRequestRepository
                .findById(request.getMovingRequestId())
                .orElseThrow(() ->
                        new RuntimeException("Moving request not found"));

        Quotation quotation = quotationRepository
                .findById(request.getQuotationId())
                .orElseThrow(() ->
                        new RuntimeException("Quotation not found"));

        if (!quotation.getMovingRequest().getId()
                .equals(movingRequest.getId())) {
            throw new RuntimeException(
                    "Quotation does not belong to the moving request");
        }

        Booking booking = new Booking(
                movingRequest,
                quotation,
                request.getBookingDate(),
                request.getStatus()
        );

        Booking savedBooking = bookingRepository.save(booking);

        return toResponseDTO(savedBooking);
    }

    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public BookingResponseDTO getBookingById(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));

        return toResponseDTO(booking);
    }

    public void deleteBooking(Long id) {

        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }

        bookingRepository.deleteById(id);
    }

    private BookingResponseDTO toResponseDTO(Booking booking) {

        return new BookingResponseDTO(
                booking.getId(),
                booking.getMovingRequest().getId(),
                booking.getQuotation().getId(),
                booking.getBookingDate(),
                booking.getStatus()
        );
    }
}