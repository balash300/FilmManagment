package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.StoreDto;
import com.example.FilmManagment.dto.request.StoreRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.StoreMapper;
import com.example.FilmManagment.model.Store;
import com.example.FilmManagment.repository.StoreRepository;
import com.example.FilmManagment.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreImpl implements StoreService {

    private final StoreRepository repository;
    private final StoreMapper mapper;

    @Override
    public StoreDto getStoreByStoreId(Long storeId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(storeId)
                .orElseThrow(()-> new ResourceNotFoundException("Store","storeId",storeId)));
    }

    @Override
    public Store saveStore(StoreRequest request) {
        Store store = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return store;
    }

    @Override
    public StoreDto updateStore(StoreRequest request) {
        log.info("Finding information for id: {}", request.getStoreId());
        if (repository.findById(request.getStoreId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getStoreId());
        } else {
            log.info("Updating information for id: {}", request.getStoreId());
            Store updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getStoreId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Store", "id", id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<StoreDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
