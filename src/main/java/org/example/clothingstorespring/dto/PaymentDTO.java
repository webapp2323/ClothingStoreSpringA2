package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDTO {
    @JsonProperty("order_id")
    private Integer orderId;

    private BigDecimal amount;
    private String method;
    private LocalDateTime paymentDate;
}

