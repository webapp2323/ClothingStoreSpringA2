package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.DeliveryStatus;
import org.example.clothingstorespring.model.DeliveryType;
import org.example.clothingstorespring.model.OrderStatus;
import org.example.clothingstorespring.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("deliveryAddress")
    private String deliveryAddress;

    @JsonProperty("deliveryDate")
    private LocalDateTime deliveryDate;

    @JsonProperty("status")
    private DeliveryStatus status;

    @JsonProperty("deliveryType")
    private DeliveryType deliveryType;
}