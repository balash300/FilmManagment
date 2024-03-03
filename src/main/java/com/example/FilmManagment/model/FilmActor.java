package com.example.FilmManagment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_actor")
public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_update", insertable = false)
    @CreationTimestamp @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastUpdate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    private Actor actor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

}
