package com.example.FilmManagment.mapper;

import com.example.FilmManagment.dto.CustomerDto;
import com.example.FilmManagment.dto.request.CustomerRequest;
import com.example.FilmManagment.model.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerRequest request);
    List<CustomerDto> dtoList(List<Customer> list);
}
