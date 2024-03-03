package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.InventoryDto;
import com.example.FilmManagment.dto.request.InventoryRequest;
import com.example.FilmManagment.model.Inventory;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {

    final InventoryService service;

    @GetMapping("/inventoryList")
    public ResponseEntity<BaseResponse<List<InventoryDto>>> getInventoryInfo() {
        List<InventoryDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Inventory list successfuly find", list));
    }

    @GetMapping("/getInventoriesByInventoryId/{inventoryId}")
    public ResponseEntity<BaseResponse<InventoryDto>> getInventoriesByInventoryId(@PathVariable(value = "inventoryId") Long inventoryId) {
        InventoryDto dto = service.getInventoriesByInventoryId(inventoryId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Inventory successfuly find", dto));
    }

    @PostMapping("/saveInventory")
    public ResponseEntity<BaseResponse<Inventory>> saveInventory(@RequestBody InventoryRequest request) {
        Inventory inventory = service.saveInventory(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Inventory successfuly saved", inventory));
    }

    @PutMapping("/updateInventory")
    public ResponseEntity<BaseResponse<InventoryDto>> updateInventory(@RequestBody InventoryRequest request) {
        InventoryDto dto = service.updateInventory(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Inventory successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}

