package com.example.FilmManagment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto{
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
}