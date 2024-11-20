package org.example.clothingstorespring.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.model.Pants;
import org.example.clothingstorespring.model.Shirt;
import org.example.clothingstorespring.repository.ShirtRepository;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class ShirtServiceImpl implements ShirtService {
    private final ShirtRepository shirtRepository;

    @Override
    public List<Shirt> getAllShirts() {
        return shirtRepository.findAll(); // Использование готового метода JPA
    }

    @Override
    public Optional<Shirt> getShirtById(Long id) {
        return shirtRepository.findById(id); // Этот метод должен возвращать Optional<Shirt>
    }



    /*
    GET http://localhost:8080/api/v1/shirts/11
    2024-10-10 09:36:02 - Received request to get shirt by id: 11
2024-10-10 09:36:02 - Retrieved shirt from repository with id: 11
2024-10-10 09:36:02 - Shirt found: {id=11, name='Lightweight Shirt', brand='Brand F', price=24.99} sleeve_Type=LONG, size=S, material='LINEN'}
     */

//    @Override
//    public Shirt addShirt(Shirt shirt) {
//        return shirtRepository.save(shirt); // Использование готового метода JPA
//    }
@Override
public Shirt addShirt(Shirt shirt) {

    shirtRepository.save(shirt);
    return shirt;
}
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
