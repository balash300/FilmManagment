package com.example.FilmManagment.controller;

import com.example.FilmManagment.dto.PaymentDto;
import com.example.FilmManagment.dto.request.PaymentRequest;
import com.example.FilmManagment.model.Payment;
import com.example.FilmManagment.model.response.BaseResponse;
import com.example.FilmManagment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    final PaymentService service;

    @GetMapping("/languageList")
    public ResponseEntity<BaseResponse<List<PaymentDto>>> getPaymentInfo() {
        List<PaymentDto> list = service.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Paymnet list successfuly find", list));
    }

    @GetMapping("/getPaymentsByPaymentId/{paymentId}")
    public ResponseEntity<BaseResponse<PaymentDto>> getPaymentsByPaymentId(@PathVariable(value = "paymentId") Long paymentId) {
        PaymentDto dto = service.getPaymentsByPaymentId(paymentId);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Payment successfuly find", dto));
    }

    @PostMapping("/savePayment")
    public ResponseEntity<BaseResponse<Payment>> savePayment(@RequestBody PaymentRequest request) {
        Payment payment = service.savePayment(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Payment successfuly saved", payment));
    }

    @PutMapping("/updatePayment")
    public ResponseEntity<BaseResponse<PaymentDto>> updatePayment(@RequestBody PaymentRequest request) {
        PaymentDto dto = service.updatePayment(request);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Payment successfuly saved", dto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Successfuly deleted");
    }
}
