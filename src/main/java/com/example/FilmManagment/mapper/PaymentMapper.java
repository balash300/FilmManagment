package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.PaymentDto;
import com.example.FilmManagment.dto.request.PaymentRequest;
import com.example.FilmManagment.model.Payment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PaymentMapper {
    PaymentDto toDto(Payment payment);
    Payment toEntity(PaymentRequest request);
    List<PaymentDto> dtoList(List<Payment> list);
}
