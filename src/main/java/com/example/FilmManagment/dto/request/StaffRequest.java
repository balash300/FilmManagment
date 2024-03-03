package com.example.FilmManagment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StaffRequest {
    private Long staffId;
    private String first_name;
    private String last_name;
    private Blob picture;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private LocalDateTime lastUpdate;
}
