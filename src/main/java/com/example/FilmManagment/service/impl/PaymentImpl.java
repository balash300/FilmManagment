package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.PaymentDto;
import com.example.FilmManagment.dto.request.PaymentRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.PaymentMapper;
import com.example.FilmManagment.model.Payment;
import com.example.FilmManagment.repository.PaymentRepository;
import com.example.FilmManagment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public PaymentDto getPaymentsByPaymentId(Long paymentId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(paymentId)
                .orElseThrow(()-> new ResourceNotFoundException("Payment","paymentId",paymentId)));
    }

    @Override
    public Payment savePayment(PaymentRequest request) {
        Payment payment = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return payment;
    }

    @Override
    public PaymentDto updatePayment(PaymentRequest request) {
        log.info("Finding information for id: {}", request.getPaymentId());
        if (repository.findById(request.getPaymentId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getPaymentId());
        } else {
            log.info("Updating information for id: {}", request.getPaymentId());
            Payment updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getPaymentId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Payment", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<PaymentDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
