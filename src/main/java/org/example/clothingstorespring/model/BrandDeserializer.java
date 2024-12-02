package org.example.clothingstorespring.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class BrandDeserializer extends JsonDeserializer<Brand> {
    @Override
    public Brand deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String brandText = p.getText().toUpperCase(); // Перетворюємо на верхній регістр
        return Brand.valueOf(brandText); // Повертаємо відповідне значення enum
    }
}