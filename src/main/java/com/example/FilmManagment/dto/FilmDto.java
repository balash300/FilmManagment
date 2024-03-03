package com.example.FilmManagment.dto;

import com.example.FilmManagment.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private String title;
    private String description;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private Long length;
    private BigDecimal replacementCost;
    private Rating rating;
    private LocalDateTime releaseYear;
    private LocalDateTime lastUpdate;
}
