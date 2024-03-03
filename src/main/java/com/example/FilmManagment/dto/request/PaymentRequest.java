package com.example.FilmManagment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Long paymentId;
    private Long rentalId;
    private BigDecimal amount;
    private Date paymentDate;
    private LocalDateTime lastUpdate;
}
