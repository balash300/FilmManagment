package com.example.FilmManagment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {
    private LocalDateTime rentalDate;
    private Date returnDate;
    private LocalDateTime lastUpdate;
}
