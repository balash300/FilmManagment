package com.example.FilmManagment.enums;

import jakarta.persistence.AttributeConverter;

public class RatingConverter implements AttributeConverter<Rating, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Rating attribute) {
        return switch (attribute){
            case BAD -> 6;
            case NOT_BAD -> 7;
            case GOOD -> 8;
            case EXCELLENT -> 9;
        };
    }

    @Override
    public Rating convertToEntityAttribute(Integer dbData) {
        return switch (dbData){
            case 6 -> Rating.BAD;
            case 7 -> Rating.NOT_BAD;
            case 8 -> Rating.GOOD;
            case 9 -> Rating.EXCELLENT;
            default -> throw new IllegalStateException("Unexpected value: " + dbData);
        };
    }
}
