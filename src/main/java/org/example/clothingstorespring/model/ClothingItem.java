package org.example.clothingstorespring.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Shirt.class, name = "shirt"),
        @JsonSubTypes.Type(value = Pants.class, name = "pants"),
        @JsonSubTypes.Type(value = Jacket.class, name = "jacket")
})

@Getter
@Setter
@Data
@Entity
@Table(name = "clothing_items") // Кореневий клас
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)

public abstract class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Size size;
    private BigDecimal price;
    @JsonDeserialize(using = BrandDeserializer.class)
    private Brand brand;

    // Публічний конструктор без параметрів
    public ClothingItem() {
    }

    // Інші конструктори, геттери та сеттери
    public ClothingItem(Long id, String name, String size, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.size = Size.valueOf(size);
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}


