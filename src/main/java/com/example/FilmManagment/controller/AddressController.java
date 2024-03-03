package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.AddressDto;
import com.example.FilmManagment.dto.request.AddressRequest;
import com.example.FilmManagment.model.Address;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    final AddressService service;

    @GetMapping("/addressList")
    public ResponseEntity<BaseResponse<List<AddressDto>>> getAddressInfo() {
        List<AddressDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Address list successfully find", list));
    }

    @GetMapping("/getAddressByAddressId/{addressId}")
    public ResponseEntity<BaseResponse<AddressDto>> getAddressByAddressId(@PathVariable(value = "addressId") Long addressId) {
        AddressDto addressDto = service.getAddressByAddressId(addressId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Address successfully find", addressDto));
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<BaseResponse<Address>> saveAddress(@RequestBody AddressRequest request) {
        Address address = service.saveAddress(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Address successfully saved", address));
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<BaseResponse<AddressDto>> updateAddress(@RequestBody AddressRequest request) {
        AddressDto address = service.updateAddress(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Address successfully saved", address));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("successfully deleted");
    }

}
