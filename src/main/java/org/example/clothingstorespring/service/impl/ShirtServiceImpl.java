package org.example.clothingstorespring.service.impl;

import lombok.AllArgsConstructor;
import org.example.clothingstorespring.model.Shirt;
import org.example.clothingstorespring.repository.ShirtRepository;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class ShirtServiceImpl implements ShirtService {
    private final ShirtRepository shirtRepository;

    @Override
    public List<Shirt> getAllShirts() {
        return shirtRepository.findAll(); // Використання готового методу JPA
    }

    @Override
    public Optional<Shirt> getShirtById(Long id) {
        return shirtRepository.findById(id); // Використання готового методу JPA
    }

    @Override
    public Shirt addShirt(Shirt shirt) {
        return shirtRepository.save(shirt); // Використання готового методу JPA
    }

    @Override
    public Shirt updateShirt(Shirt shirt) {
        return shirtRepository.save(shirt); // Використання готового методу JPA для оновлення
    }

    @Override
    public void deleteShirt(Shirt shirt) {
        shirtRepository.delete(shirt); // Використання готового методу JPA
    }
}