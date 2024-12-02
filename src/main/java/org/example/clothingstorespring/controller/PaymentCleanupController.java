package org.example.clothingstorespring.controller;

import org.example.clothingstorespring.service.scheduled.PaymentCleanupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentCleanupController {

    private final PaymentCleanupService paymentCleanupService;

    @Autowired
    public PaymentCleanupController(PaymentCleanupService paymentCleanupService) {
        this.paymentCleanupService = paymentCleanupService;
    }

    @PostMapping("/cleanup-payments")
    public String triggerCleanup() {
        paymentCleanupService.deleteOldPayments();
        return "Payment cleanup triggered.";
    }
}