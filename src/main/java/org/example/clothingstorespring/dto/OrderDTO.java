package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.OrderStatus;
import org.example.clothingstorespring.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {

    @JsonProperty("user")
    private User user;

    private String customerName;

    private BigDecimal total;
    private LocalDateTime orderDate;
    private OrderStatus status;
}


