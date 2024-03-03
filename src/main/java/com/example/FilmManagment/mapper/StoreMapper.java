package com.example.FilmManagment.mapper;


import com.example.FilmManagment.dto.StoreDto;
import com.example.FilmManagment.dto.request.StoreRequest;
import com.example.FilmManagment.model.Store;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StoreMapper {
    StoreDto toDto(Store store);
    Store toEntity(StoreRequest request);
    List<StoreDto> dtoList(List<Store> list);
}
