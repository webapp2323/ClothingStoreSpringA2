package org.example.clothingstorespring.repository;

import org.example.clothingstorespring.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
