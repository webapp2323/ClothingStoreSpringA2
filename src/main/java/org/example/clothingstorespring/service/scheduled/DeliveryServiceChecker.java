package org.example.clothingstorespring.service.scheduled;


import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.model.DeliveryStatus;
import org.example.clothingstorespring.service.DeliveryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DeliveryServiceChecker {

    private final DeliveryService deliveryService;

    public DeliveryServiceChecker(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Scheduled(cron = "0 0 * * * *") // кожну годину
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateDeliveryStatus() {
        try {
            List<Delivery> pendingDeliveries = deliveryService.findAllPending();

            // Логування стану чекаючих доставок
            if (pendingDeliveries.isEmpty()) {
                log.info("No pending deliveries found.");
                return;
            } else {
                log.info("Found {} pending deliveries:", pendingDeliveries.size());
                pendingDeliveries.forEach(delivery -> log.info("Pending delivery ID: {}", delivery.getId()));
            }

            pendingDeliveries.forEach(delivery -> {
                delivery.setStatus(DeliveryStatus.IN_TRANSIT);
                deliveryService.save(delivery);
                log.info("Updated delivery ID: {} to status: {}", delivery.getId(), DeliveryStatus.IN_TRANSIT);
            });

        } catch (Exception e) {
            log.error("An error occurred while updating delivery status: {}", e.getMessage());
        }
    }
}