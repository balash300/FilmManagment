package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.AddressDto;
import com.example.FilmManagment.dto.request.AddressRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.AddressMapper;
import com.example.FilmManagment.model.Address;
import com.example.FilmManagment.repository.AddressRepository;
import com.example.FilmManagment.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressDto getAddressByAddressId(Long addressId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException("Address","addressId",addressId)));
    }

    @Override
    public Address saveAddress(AddressRequest request) {
        Address address = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return address;
    }

    @Override
    public AddressDto updateAddress(AddressRequest request) {
        log.info("Finding information for id: {}", request.getAddressId());
        if (repository.findById(request.getAddressId()).isEmpty()) {
            throw new ResourceNotFoundException("Address", "id", request.getAddressId());
        } else {
            log.info("Updating information for id: {}", request.getAddressId());
            Address updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getAddressId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Address","id",id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<AddressDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
