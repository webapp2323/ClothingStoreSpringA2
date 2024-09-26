package org.example.clothingstorespring.service.impl;


import org.example.clothingstorespring.entity.Shirt;
import org.example.clothingstorespring.repository.ShirtRepository;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtServiceImpl implements ShirtService {

    private final ShirtRepository shirtRepository;

    public ShirtServiceImpl(ShirtRepository shirtRepository) {
        this.shirtRepository = shirtRepository;
    }

    @Override
    public void addShirt(Shirt shirt) {
        shirtRepository.save(shirt);
    }

    @Override
    public List<Shirt> getAllShirts() {
        return shirtRepository.findAll();
    }

    @Override
    public Shirt getShirtById(Long id) {
        return shirtRepository.findById(id).orElse(null);
    }

    @Override
    public void updateShirt(Shirt shirt) {
        shirtRepository.save(shirt);
    }

    @Override
    public void deleteShirt(Shirt shirt) {
        shirtRepository.delete(shirt);
    }



}
