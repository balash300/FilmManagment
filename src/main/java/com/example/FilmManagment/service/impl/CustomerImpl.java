package com.example.FilmManagment.service.impl;

import com.example.FilmManagment.dto.CustomerDto;
import com.example.FilmManagment.dto.request.CustomerRequest;
import com.example.FilmManagment.exception.ResourceNotFoundException;
import com.example.FilmManagment.mapper.CustomerMapper;
import com.example.FilmManagment.model.Customer;
import com.example.FilmManagment.repository.CustomerRepository;
import com.example.FilmManagment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public CustomerDto getCustomerByCustomerId(Long customerId) {
        log.info("Information is sought");
        return mapper.toDto(repository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer", "customerId", customerId)));
    }

    @Override
    public Customer saveCustomer(CustomerRequest request) {
        Customer customer = repository.save(mapper.toEntity(request));
        log.info("Noted");
        return customer;
    }

    @Override
    public CustomerDto updateCustomer(CustomerRequest request) {
        log.info("Finding information for id: {}", request.getCustomerId());
        if (repository.findById(request.getCustomerId()).isEmpty()) {
            throw new ResourceNotFoundException("Customer", "id", request.getCustomerId());
        } else {
            log.info("Updating information for id: {}", request.getCustomerId());
            Customer updated = repository.save(mapper.toEntity(request));
            log.info("This information updated successfully for id: {}", request.getCustomerId());
            return mapper.toDto(updated);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("Information not found");
            throw new ResourceNotFoundException("Customer","id",id);
        } else {
            log.info("Deleted information");
            repository.deleteById(id);
        }
    }

    @Override
    public List<CustomerDto> getAll() {
        log.info("Whole list finding...");
        return mapper.dtoList(repository.findAll());
    }
}
