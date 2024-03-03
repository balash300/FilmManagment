package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.StoreDto;
import com.example.FilmManagment.dto.request.StoreRequest;
import com.example.FilmManagment.model.Store;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    final StoreService service;

    @GetMapping("/storeList")
    public ResponseEntity<BaseResponse<List<StoreDto>>> getStoreInfo() {
        List<StoreDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Store list successfuly find", list));
    }

    @GetMapping("/getStoreByStoreId/{storeId}")
    public ResponseEntity<BaseResponse<StoreDto>> getStoreByStoreId(@PathVariable(value = "storeId") Long storeId) {
        StoreDto dto = service.getStoreByStoreId(storeId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Store successfuly find", dto));
    }

    @PostMapping("/saveStore")
    public ResponseEntity<BaseResponse<Store>> saveStore(@RequestBody StoreRequest request) {
        Store store = service.saveStore(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Store successfuly saved", store));
    }

    @PutMapping("/updateStore")
    public ResponseEntity<BaseResponse<StoreDto>> updateStore(@RequestBody StoreRequest request) {
        StoreDto dto = service.updateStore(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Store successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
