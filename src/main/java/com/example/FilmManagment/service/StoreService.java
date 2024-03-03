package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.StoreDto;
import com.example.FilmManagment.dto.request.StoreRequest;
import com.example.FilmManagment.model.Store;

import java.util.List;

public interface StoreService {

    StoreDto getStoreByStoreId(Long storeId);
    Store saveStore(StoreRequest request);
    StoreDto updateStore(StoreRequest request);
    void deleteById(Long id);
    List<StoreDto> getAll();

}
