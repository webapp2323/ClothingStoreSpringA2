package org.example.clothingstorespring.service.impl;

import jakarta.persistence.EntityNotFoundException;

import org.example.clothingstorespring.model.*;
import org.example.clothingstorespring.repository.PromotionRepository;
import org.example.clothingstorespring.service.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    private static final Logger log = LoggerFactory.getLogger(PromotionServiceImpl.class);
    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void addPromotion(Promotion promotion) {
        promotionRepository.save(promotion);

    }

    @Override
    public void deletePromotion(Long id) {
        if (!promotionRepository.existsById(id)) {
            throw new EntityNotFoundException("Promotion not found for ID: " + id);
        }
        promotionRepository.deleteById(id);

    }

    @Override
    public Promotion updatePromotion(Long id, Promotion promotion) {
        Promotion existingPromotion = getPromotionById(id);
        existingPromotion.setName(promotion.getName());
        existingPromotion.setDescription(promotion.getDescription());
        existingPromotion.setType(promotion.getType());
        existingPromotion.setDiscount(promotion.getDiscount());
        existingPromotion.setStartDate(promotion.getStartDate());
        existingPromotion.setEndDate(promotion.getEndDate());
        existingPromotion.setClothingItems(promotion.getClothingItems());

        Promotion updatedPromotion = promotionRepository.save(existingPromotion);

        return updatedPromotion;
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion  for ID: " + id + " not found"));
    }

    public Set<ClothingItem> convertToEntity(Set<org.example.clothingstorespring.service.impl.ClothingItemDTO> clothingItemDTOs) {
        return clothingItemDTOs.stream()
                .map(dto -> {
                    try {
                        return new ClothingItem(
                                dto.getId(),
                                dto.getName(),
                                Size.valueOf(dto.getSize().toUpperCase()),
                                dto.getPrice(),
                                Brand.valueOf(dto.getBrand().toUpperCase()),
                                ClothingItemType.valueOf(dto.getType().toUpperCase())
                        );
                    } catch (IllegalArgumentException e) {
                        log.error("Invalid size, brand, or type: " + e.getMessage());
                        return null; // Или выбрасываем исключение, если необходимо
                    }
                })
                .filter(Objects::nonNull) // Удаляем null-значения, если они были
                .collect(Collectors.toSet());
    }
}
