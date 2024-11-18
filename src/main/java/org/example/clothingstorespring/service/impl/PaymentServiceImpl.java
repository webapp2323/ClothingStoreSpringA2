package org.example.clothingstorespring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.PaymentDTO;
import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.Payment;
import org.example.clothingstorespring.model.PaymentResponse;
import org.example.clothingstorespring.repository.PaymentRepository;
import org.example.clothingstorespring.service.OrderService;
import org.example.clothingstorespring.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private  final OrderService orderService;

    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderService orderService) {
        this.paymentRepository = paymentRepository;
        this.orderService = orderService;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentResponse processPayment(Order order) {
        boolean paymentSuccessful;
        String message;


        paymentSuccessful = true;
        message = paymentSuccessful ? "Payment processed successfully." : "Payment failed.";

        log.info(message);

        return new PaymentResponse(paymentSuccessful, message);
    }

    @Override
    @Transactional
    public Payment createPayment(PaymentDTO payment) {
        log.info("Creating payment: {}", payment);

        if (payment == null) {
            log.error("Payment must not be null");
            throw new IllegalArgumentException("Payment must not be null");
        }

        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            log.error("Payment amount must be greater than zero");
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }

        if (payment.getMethod() == null || payment.getMethod().isEmpty()) {
            log.error("Payment method must not be empty");
            throw new IllegalArgumentException("Payment method must not be empty");
        }

        if (payment.getPaymentDate() == null) {
            log.error("Payment date must not be null");
            throw new IllegalArgumentException("Payment date must not be null");
        }

        List<String> validMethods = Arrays.asList("CREDIT_CARD", "PAYPAL", "BANK_TRANSFER");
        if (!validMethods.contains(payment.getMethod())) {
            log.error("Invalid payment method: {}", payment.getMethod());
            throw new IllegalArgumentException("Invalid payment method: " + payment.getMethod());
        }
        Order order = orderService.findOrderById(Long.valueOf(payment.getOrderId()));


        Payment payment1 = new Payment();
        payment1.setAmount(payment.getAmount());
        payment1.setOrder(order);
        payment1.setMethod(payment.getMethod());
        payment1.setPaymentDate(payment.getPaymentDate());

        Payment savedPayment = paymentRepository.save(payment1);
        log.info("Payment created successfully: {}", savedPayment);
        return savedPayment;
    }
}