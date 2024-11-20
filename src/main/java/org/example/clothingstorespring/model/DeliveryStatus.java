package org.example.clothingstorespring.model;

public enum DeliveryStatus {
    PENDING,
    IN_TRANSIT,
    DELIVERED,
    CANCELED;

    public String toUpperCase() {
        return name().toUpperCase();
    }
}