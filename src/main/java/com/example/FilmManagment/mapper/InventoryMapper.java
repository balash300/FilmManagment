package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.InventoryDto;
import com.example.FilmManagment.dto.request.InventoryRequest;
import com.example.FilmManagment.model.Inventory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface InventoryMapper {
    InventoryDto toDto(Inventory inventory);
    Inventory toEntity(InventoryRequest request);
    List<InventoryDto> dtoList(List<Inventory> list);
}
