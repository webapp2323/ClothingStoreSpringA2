package org.example.clothingstorespring.service.scheduled;


import org.example.clothingstorespring.model.Delivery;
import org.example.clothingstorespring.model.DeliveryStatus;
import org.example.clothingstorespring.service.DeliveryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class DeliveryServiceChecker {

    private final DeliveryService deliveryService;

    public DeliveryServiceChecker(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Scheduled(cron = "0 0 * * * *") // кожну годину
//     @Scheduled(fixedDelay = 10000) //Кожні 10 секунд
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public void updateDeliveryStatus(){
        try {

            List<Delivery> pendingDeliveries = deliveryService.findAllPending();

            if (pendingDeliveries.isEmpty()) {
                return;
            }

            pendingDeliveries.forEach(delivery -> {
                delivery.setStatus(DeliveryStatus.IN_TRANSIT);
                deliveryService.save(delivery);
            });

        } catch (Exception e) {
        }
    }
}