package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {


    private Long id;

    @JsonProperty("customer_name")
    private String customerName;


    private BigDecimal total;

    @JsonProperty("order_date")
    private LocalDateTime orderDate;


    private OrderStatus status;
}

