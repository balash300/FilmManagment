package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.AddressDto;
import com.example.FilmManagment.dto.request.AddressRequest;
import com.example.FilmManagment.model.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressRequest request);
    List<AddressDto> dtoList(List<Address> list);
}
