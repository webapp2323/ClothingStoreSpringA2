package org.example.clothingstorespring.model;

public class PaymentResponse {
    private boolean successful; // Статус успішності платежу
    private String message; // Повідомлення про статус платежу (наприклад, причина невдачі)

    // Конструктор
    public PaymentResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    // Геттери та сеттери
    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

