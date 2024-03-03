package com.example.FilmManagment.model;

import com.example.FilmManagment.enums.Rating;
import com.example.FilmManagment.enums.RatingConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;
    @NotNull
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    @NotNull
    private String description;
    @Column(name = "original_language_id")
    @NotBlank
    @JdbcTypeCode(SqlTypes.TINYINT)
    private Integer originalLanguageId;
    @Column(name = "rental_duration")
    @JdbcTypeCode(SqlTypes.TINYINT)
    @NotBlank
    private Integer rentalDuration;
    @Column(name = "rental_rate", precision = 4, scale = 2)
    @NotNull
    private BigDecimal rentalRate;
    @NotNull
    private Long length;
    @Column(name = "replacement_cost", precision = 5, scale = 2)
    @NotNull
    private BigDecimal replacementCost;
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    @Convert(converter = RatingConverter.class)
    private Rating rating;

    @Column(name = "release_year", updatable = false)
    @CreationTimestamp @NotNull
    @DateTimeFormat(pattern = "yyyy")
    private LocalDateTime releaseYear;

    @Column(name = "last_update", insertable = false)
    @CreationTimestamp @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmActor> filmActors = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmCategory> filmCategories = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventories = new ArrayList<>();

}
