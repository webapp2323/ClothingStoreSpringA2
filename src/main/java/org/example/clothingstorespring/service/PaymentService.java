package org.example.clothingstorespring.service;

import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.Payment;
import org.example.clothingstorespring.model.PaymentResponse;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    PaymentResponse processPayment(Order order);
    Payment createPayment(Payment payment);
}