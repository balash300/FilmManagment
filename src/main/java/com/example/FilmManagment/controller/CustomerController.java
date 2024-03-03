package com.example.FilmManagment.controller;


import com.example.FilmManagment.dto.CustomerDto;
import com.example.FilmManagment.dto.request.CustomerRequest;
import com.example.FilmManagment.model.Customer;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Customer")
public class CustomerController {

    final CustomerService service;

    @GetMapping("/customerList")
    public ResponseEntity<BaseResponse<List<CustomerDto>>> getCustomerInfo() {
        List<CustomerDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Customer list successfuly find", list));
    }

    @GetMapping("/getCustomerByCustomerId/{customerId}")
    public ResponseEntity<BaseResponse<CustomerDto>> getCustomerByCustomerId(@PathVariable(value = "customerId") Long customerId) {
        CustomerDto dto = service.getCustomerByCustomerId(customerId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Customer successfuly find", dto));
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<BaseResponse<Customer>> saveCustomer(@RequestBody CustomerRequest request) {
        Customer customer = service.saveCustomer(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Customer successfuly saved", customer));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<BaseResponse<CustomerDto>> updateCustomer(@RequestBody CustomerRequest request) {
        CustomerDto dto = service.updateCustomer(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Customer successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }

}
