package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.ClothingItem;
import org.example.clothingstorespring.repository.ClothingItemRepository;
import org.example.clothingstorespring.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingItemServiceImpl implements ClothingItemService {

    private final ClothingItemRepository clothingItemRepository;

    @Autowired
    public ClothingItemServiceImpl(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    @Override
    public List<ClothingItem> getAllClothingItems() {
        return clothingItemRepository.findAll();
    }

    @Override
    public Optional<ClothingItem> getClothingItemById(Long id) {
        return clothingItemRepository.findById(id);
    }

    @Override
    public ClothingItem addClothingItem(@Valid ClothingItem clothingItem) {
        return clothingItemRepository.save(clothingItem);
    }

    @Override
    public ClothingItem updateClothingItem(Long id, @Valid ClothingItem clothingItem) {
        clothingItem.setId(id); // Устанавливаем ID для обновления
        return clothingItemRepository.save(clothingItem);
    }

    @Override
    public void deleteClothingItem(Long id) {
        clothingItemRepository.deleteById(id);
    }

    @Override
    public ClothingItem findById(Long key) {
        return clothingItemRepository.findById(key)
                .orElseThrow(() -> new IllegalArgumentException("Clothing item not found with id: " + key));
    }
}