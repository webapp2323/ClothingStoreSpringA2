package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.dto.OrderDTO;
import org.example.clothingstorespring.model.ClothingItem;
import org.example.clothingstorespring.model.OrderItem;
import org.example.clothingstorespring.repository.ClothingItemRepository;
import org.example.clothingstorespring.repository.OrderItemRepository;
import org.example.clothingstorespring.repository.OrderRepository;
import org.example.clothingstorespring.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.clothingstorespring.model.Order;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClothingItemServiceImpl implements ClothingItemService {

    private final ClothingItemRepository clothingItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private Order order; // Измените на правильный тип Order
    private OrderDTO orderDTO;


    public ClothingItemServiceImpl(ClothingItemRepository clothingItemRepository,
                                   OrderItemRepository orderItemRepository,
                                   OrderRepository orderRepository)
                                    {
        this.clothingItemRepository = clothingItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.orderDTO = new OrderDTO();

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
        if (orderDTO == null) {
            throw new IllegalArgumentException("OrderDTO is not initialized.");
        }

        // Перебираем элементы заказа из OrderDTO
        ClothingItem clothingItem = null;
        for (Map.Entry<Long, Integer> entry : orderDTO.getItems().entrySet()) {
            Long clothingId = entry.getKey();
            Integer quantity = entry.getValue();

            // Находим элемент одежды по ID
            clothingItem = clothingItemRepository.findById(clothingId)
                    .orElseThrow(() -> new IllegalArgumentException("Clothing item not found with id: " + clothingId));

            // Создаем новый элемент заказа
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(quantity);
            orderItem.setClothingItem(clothingItem);
            orderItem.setOrder(order); // Убедитесь, что order инициализирован

            // Сохраняем элемент заказа
            orderItemRepository.save(orderItem);
        }

        // Верните последний clothingItem или измените логику возврата
        return clothingItem; // Возвращает последний найденный элемент
    }
}

    


    
