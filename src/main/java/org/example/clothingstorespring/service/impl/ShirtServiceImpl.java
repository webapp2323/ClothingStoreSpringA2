package org.example.clothingstorespring.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.AddShirtDTO;
import org.example.clothingstorespring.dto.AddShirtResponseDTO;
import org.example.clothingstorespring.model.Brand;
import org.example.clothingstorespring.model.Shirt;
import org.example.clothingstorespring.repository.ShirtRepository;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ShirtServiceImpl implements ShirtService {
    private final ShirtRepository shirtRepository;




    @Override
    public List<Shirt> getAllShirts() {
        return shirtRepository.findAll();


    }

    @Override
    public Optional<Shirt> getShirtById(Long id) {
        return Optional.empty();
    }



    @Override
    public AddShirtResponseDTO addShirt(AddShirtDTO shirtDTO) {

        // Проверка валидности входных данных
        if (shirtDTO.getName() == null || shirtDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (shirtDTO.getBrand() == null || shirtDTO.getBrand().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (shirtDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (shirtDTO.getSize() == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        if (shirtDTO.getMaterial() == null) {
            throw new IllegalArgumentException("Material cannot be null");
        }
        if (shirtDTO.getColor() == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        if (shirtDTO.getSleeve_type() == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }

        Shirt shirt = new Shirt();
        shirt.setName(shirtDTO.getName());
        shirt.setMaterial(shirtDTO.getMaterial());
        shirt.setPrice(shirtDTO.getPrice());
        shirt.setBrand(Brand.valueOf(shirtDTO.getBrand()));
        shirt.setColor(shirtDTO.getColor());
        shirt.setSize(shirtDTO.getSize());
        shirt.setSleeve_type(shirtDTO.getSleeve_type());
        shirtRepository.save(shirt);

        // Создание объекта ответа с корректными данными
        AddShirtResponseDTO responseDTO = new AddShirtResponseDTO();
        responseDTO.setId(shirt.getId());
        responseDTO.setName(shirtDTO.getName());
        responseDTO.setMaterial(shirtDTO.getMaterial());
        responseDTO.setColor(shirtDTO.getColor());
        responseDTO.setSize(shirtDTO.getSize());
        responseDTO.setBrand(shirtDTO.getBrand());
        responseDTO.setPrice(shirtDTO.getPrice());
        responseDTO.setSleeve_type(shirtDTO.getSleeve_type());

        responseDTO.setMessage("shirt added successfully !");
        return responseDTO;
    }

    //@Override
//public Shirt addShirt(Shirt shirt) {
//
//    shirtRepository.save(shirt);
//    return shirt;
//}
    @Override
    public Shirt updateShirt(Shirt shirt) {
        return shirtRepository.save(shirt); // Использование готового метода JPA для обновления
    }

    @Override
    public void deleteShirt(Long id) {
        if (!shirtRepository.existsById(id)) {
            throw new EntityNotFoundException("Shirt not found with id: " + id);
        }
        shirtRepository.deleteById(id);
    }

    @Override
    public List<Shirt> getShirtsByIds(List<Long> ids) {
        return List.of();
    }


}
