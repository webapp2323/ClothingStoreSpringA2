package org.example.clothingstorespring.model;

public enum DeliveryType {
    STANDARD,
    EXPRESS,
    OVERNIGHT;

    public String toUpperCase() {
        return name().toUpperCase();

    }
}