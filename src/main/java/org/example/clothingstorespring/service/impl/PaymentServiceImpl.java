package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.Order;
import org.example.clothingstorespring.model.Payment;
import org.example.clothingstorespring.model.PaymentException;
import org.example.clothingstorespring.model.PaymentResponse;
import org.example.clothingstorespring.repository.PaymentRepository;
import org.example.clothingstorespring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentResponse processPayment(Order order) {
        // Логіка обробки платежу
        // Це місце, де ви підключаєтеся до платіжної системи

        // Приклад простого симуляційного процесу
        boolean paymentSuccessful;
        String message;

        // Тут реалізуйте вашу логіку для перевірки платіжних даних
        // Для прикладу, ми просто вирішимо, що платіж завжди успішний
        paymentSuccessful = true; // Змініть це на реальну логіку
        message = paymentSuccessful ? "Payment processed successfully." : "Payment failed.";

        return new PaymentResponse(paymentSuccessful, message);
    }

    @Override
    @Transactional
    public Payment createPayment(Payment payment) {
        logger.info("Creating payment: {}", payment);

        // Перевірка на null
        if (payment == null) {
            throw new IllegalArgumentException("Payment must not be null");
        }

        // Валідація значення amount
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }

        // Валідація методу оплати
        if (payment.getMethod() == null || payment.getMethod().isEmpty()) {
            throw new IllegalArgumentException("Payment method must not be empty");
        }

        // Валідація дати оплати
        if (payment.getPaymentDate() == null) {
            throw new IllegalArgumentException("Payment date must not be null");
        }

        // Додаткові перевірки, залежно від вимог
        List<String> validMethods = Arrays.asList("CREDIT_CARD", "PAYPAL", "BANK_TRANSFER");
        if (!validMethods.contains(payment.getMethod())) {
            throw new IllegalArgumentException("Invalid payment method: " + payment.getMethod());
        }

        // Збереження платіжного об'єкта
        Payment savedPayment = paymentRepository.save(payment); // Збережіть у змінну

        logger.info("Payment created successfully: {}", savedPayment);
        return savedPayment; // Повертаємо збережений платіж
    }
}