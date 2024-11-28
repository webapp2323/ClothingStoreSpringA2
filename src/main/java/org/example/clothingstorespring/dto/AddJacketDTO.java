package org.example.clothingstorespring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clothingstorespring.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.Name;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddJacketDTO {

    private static final Logger logger = LoggerFactory.getLogger(AddJacketDTO.class);


    private String name;


    private BigDecimal price;


    private String brand;


    private Size size;


    private Material material;


    private Color color;

    @JsonProperty("has_Hood")
    private boolean hasHood;

    @PostConstruct
    public void logData() {
        logger.info("AddJacketDTO created: name={}, brand={}, price={}, size={}, material={}, color={}, hasHood={}",
                name, brand, price, size, material, color, hasHood);
    }
}
