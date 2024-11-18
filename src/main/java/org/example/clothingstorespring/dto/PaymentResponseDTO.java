package org.example.clothingstorespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResponseDTO {

    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private String method;
    private LocalDateTime paymentDate;

}