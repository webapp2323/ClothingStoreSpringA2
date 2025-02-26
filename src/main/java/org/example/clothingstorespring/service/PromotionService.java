package org.example.clothingstorespring.service;

import org.example.clothingstorespring.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {

    void addPromotion(Promotion promotion);


    void deletePromotion(Long id);


    Promotion updatePromotion(Long id, Promotion promotion);


    List<Promotion> getAllPromotions();


    Promotion getPromotionById(Long id);
}
