package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.InventoryDto;
import com.example.FilmManagment.dto.request.InventoryRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.InventoryMapper;
import com.example.FilmManagment.model.Inventory;
import com.example.FilmManagment.repository.InventoryRepository;
import com.example.FilmManagment.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryImpl implements InventoryService {

    private final InventoryRepository repository;
    private final InventoryMapper mapper;

    @Override
    public InventoryDto getInventoriesByInventoryId(Long inventoryId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(inventoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Inventory","inventoryId",inventoryId)));
    }

    @Override
    public Inventory saveInventory(InventoryRequest request) {
        Inventory inventory = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return inventory;
    }

    @Override
    public InventoryDto updateInventory(InventoryRequest request) {
        log.info("Finding information for id: {}", request.getInventoryId());
        if (repository.findById(request.getInventoryId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getInventoryId());
        } else {
            log.info("Updating information for id: {}", request.getInventoryId());
            Inventory updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getInventoryId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Inventory", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<InventoryDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());    }
}
