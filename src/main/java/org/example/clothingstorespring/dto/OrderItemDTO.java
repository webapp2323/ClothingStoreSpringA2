package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.example.clothingstorespring.model.ClothingItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {

    private Long id;

    @JsonProperty("clothing_item")
    private ClothingItem clothingItem;

    private Integer quantity;


    @JsonProperty("order_id")
    private long orderId;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    @JsonProperty("date")
    private LocalDateTime createdDate;

    private String status;
}
