package org.example.clothingstorespring.service;

import org.example.clothingstorespring.model.ClothingItem;

import java.util.List;
import java.util.Optional;

public interface ClothingItemService {
    List<ClothingItem> getAllClothingItems();
    Optional<ClothingItem> getClothingItemById(Long id);
    ClothingItem addClothingItem(ClothingItem clothingItem);
    ClothingItem updateClothingItem(Long id, ClothingItem clothingItem);
    void deleteClothingItem(Long id);

    ClothingItem findById(Long key);
}