package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.AddressDto;
import com.example.FilmManagment.dto.request.AddressRequest;
import com.example.FilmManagment.model.Address;

import java.util.List;

public interface AddressService {

    AddressDto getAddressByAddressId(Long addressId);
    Address saveAddress(AddressRequest request);
    AddressDto updateAddress(AddressRequest request);
    void deleteById(Long id);
    List<AddressDto> getAll();

}
