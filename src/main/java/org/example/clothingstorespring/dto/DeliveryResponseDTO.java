package org.example.clothingstorespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.DeliveryStatus;
import org.example.clothingstorespring.model.DeliveryType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryResponseDTO {

    private Long id;
    private Long orderId;
    private String deliveryAddress;
    private LocalDateTime deliveryDate;
    private DeliveryStatus status;
    private DeliveryType deliveryType;


}