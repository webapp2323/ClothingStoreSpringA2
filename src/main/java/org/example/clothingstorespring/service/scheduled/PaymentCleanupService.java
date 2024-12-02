package org.example.clothingstorespring.service.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.model.Payment;
import org.example.clothingstorespring.service.PaymentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PaymentCleanupService {

    private final PaymentService paymentService;

    public PaymentCleanupService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Scheduled(cron = "0 0 0 * * *") // Щодня опівночі
    @Transactional
    public void deleteOldPayments() {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        List<Payment> oldPayments = paymentService.findPaymentsOlderThan(oneYearAgo);

        if (oldPayments.isEmpty()) {
            log.info("No old payments found to delete.");
            return;
        }

        log.info("Found {} old payments to delete:", oldPayments.size());
        oldPayments.forEach(payment -> log.info("Old payment ID: {}, Amount: {}", payment.getId(), payment.getAmount()));

        oldPayments.forEach(payment -> {
            paymentService.deletePayment(payment);
            log.info("Deleted payment with ID: {}", payment.getId());
        });

        log.info("Deleted {} old payments.", oldPayments.size());
    }
}