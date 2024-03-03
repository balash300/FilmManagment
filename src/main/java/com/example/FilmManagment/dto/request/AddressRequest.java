package com.example.FilmManagment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Long addressId;
    private String address;
    private String address2;
    private String district;
    private String postal_code;
    private String phone;
    private LocalDateTime lastUpdate;
}
