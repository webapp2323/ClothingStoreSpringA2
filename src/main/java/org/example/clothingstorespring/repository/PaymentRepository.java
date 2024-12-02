package org.example.clothingstorespring.repository;

import org.example.clothingstorespring.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPaymentDateBefore(LocalDateTime date);


}
