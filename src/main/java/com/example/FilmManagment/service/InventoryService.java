package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.InventoryDto;
import com.example.FilmManagment.dto.request.InventoryRequest;
import com.example.FilmManagment.model.Inventory;

import java.util.List;

public interface InventoryService {

    InventoryDto getInventoriesByInventoryId(Long inventoryId);
    Inventory saveInventory(InventoryRequest request);
    InventoryDto updateInventory(InventoryRequest request);
    void deleteById(Long id);
    List<InventoryDto> getAll();

}
