package org.example.clothingstorespring.model;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}