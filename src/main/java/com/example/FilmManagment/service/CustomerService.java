package com.example.FilmManagment.service;

import com.example.FilmManagment.dto.CustomerDto;
import com.example.FilmManagment.dto.request.CustomerRequest;
import com.example.FilmManagment.model.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDto getCustomerByCustomerId(Long customerId);
    Customer saveCustomer(CustomerRequest request);
    CustomerDto updateCustomer(CustomerRequest request);
    void deleteById(Long id);
    List<CustomerDto> getAll();

}
