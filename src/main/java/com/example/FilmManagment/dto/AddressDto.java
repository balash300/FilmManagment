package com.example.FilmManagment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String address;
    private String address2;
    private String district;
    private String phone;
    private LocalDateTime lastUpdate;
}
