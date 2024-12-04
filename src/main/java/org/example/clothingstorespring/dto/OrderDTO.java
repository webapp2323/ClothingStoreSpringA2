package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.ClothingItem;
import org.example.clothingstorespring.model.OrderStatus;
import org.example.clothingstorespring.model.User;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @JsonProperty("user")
    private User user;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("order_date")
    private LocalDateTime orderDate;

    @JsonProperty("status")
    private OrderStatus status;

    @JsonProperty("payment")
    private PaymentDTO payment;

    @JsonProperty("delivery")
    private DeliveryDTO delivery;

    @JsonProperty("items") // Поле для хранения элементов одежды и их количества
    @NotNull
    private Map<Long, Integer> items; // Ключ: ID элемента одежды, Значение: количество


}

