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
public class CustomerRequest {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
