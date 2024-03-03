package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.PaymentDto;
import com.example.FilmManagment.dto.request.PaymentRequest;
import com.example.FilmManagment.model.Payment;

import java.util.List;

public interface PaymentService {

    PaymentDto getPaymentsByPaymentId(Long paymentId);
    Payment savePayment(PaymentRequest request);
    PaymentDto updatePayment(PaymentRequest request);
    void deleteById(Long id);
    List<PaymentDto> getAll();

}
