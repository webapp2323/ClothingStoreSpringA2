package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.dto.PaymentDTO;
import org.example.clothingstorespring.dto.PaymentResponseDTO;
import org.example.clothingstorespring.model.Payment;
import org.example.clothingstorespring.model.PaymentResponse;
import org.example.clothingstorespring.service.PaymentService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private PaymentService paymentService;

    //Поганий приклад як не треба робити респонси. Коли ми повертаємо ЕНТІНІ, то можуть бути циклічні залежності.
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDTO payment) {
        logger.info("Received payment request: {}", payment);
        try {
            logger.info("Creating payment: {}", payment);
            Payment createdPayment = paymentService.createPayment(payment);
            logger.info("Payment created successfully: {}", createdPayment);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
        } catch (Exception e) {
            logger.error("Error creating payment: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //А ось чому треба використовувати ДТО (DTO)
    @PostMapping("/correct")
    public ResponseEntity<PaymentResponseDTO> createPaymentWithCorrectResponse(@RequestBody PaymentDTO payment) {
        try {
            Payment createdPayment = paymentService.createPayment(payment);
            logger.info("Payment created successfully: {}", createdPayment);

            PaymentResponseDTO responseDTO = mapToResponseDTO(createdPayment);

            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (Exception e) {
            logger.error("Error creating payment: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        try {
            logger.info("Retrieving all payments");
            List<Payment> payments = paymentService.getAllPayments();
            List<PaymentResponseDTO> responseDTOs = payments.stream()
                    .map(this::mapToResponseDTO)
                    .toList();
            logger.info("Retrieved {} payments", responseDTOs.size());
            return ResponseEntity.ok(responseDTOs);
        } catch (Exception e) {
            logger.error("Error retrieving payments: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private PaymentResponseDTO mapToResponseDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrder().getId());
        dto.setAmount(payment.getAmount());
        dto.setMethod(payment.getMethod());
        dto.setPaymentDate(payment.getPaymentDate());
        return dto;
    }
}