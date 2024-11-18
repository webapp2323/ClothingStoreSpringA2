package org.example.clothingstorespring.dto;

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
    private String customerName;
    private BigDecimal total;
    private LocalDateTime orderDate;
    private OrderStatus status;

}