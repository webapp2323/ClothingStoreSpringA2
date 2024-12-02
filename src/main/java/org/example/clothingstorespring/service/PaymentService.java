package org.example.clothingstorespring.service;

import org.example.clothingstorespring.dto.PaymentDTO;
import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.Payment;
import org.example.clothingstorespring.model.PaymentResponse;

import java.time.LocalDate;
import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    PaymentResponse processPayment(Order order);
    Payment createPayment(PaymentDTO payment);
    void deletePayment(Payment payment);

    List<Payment> findPaymentsOlderThan(LocalDate oneYearAgo);
}