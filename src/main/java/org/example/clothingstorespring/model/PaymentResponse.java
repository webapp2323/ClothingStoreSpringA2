package org.example.clothingstorespring.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponse {
    private boolean successful;
    private String message;


    public PaymentResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }


}

