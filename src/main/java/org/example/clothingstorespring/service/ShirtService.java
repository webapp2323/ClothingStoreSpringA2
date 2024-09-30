package org.example.clothingstorespring.service;



import org.example.clothingstorespring.model.Shirt;

import java.util.List;
import java.util.Optional;

public interface ShirtService {
    List<Shirt> getAllShirts();
     Optional<Shirt> getShirtById(Long id);
    Shirt addShirt(Shirt shirt);
    Shirt updateShirt(Shirt shirt);
    void deleteShirt(Shirt shirt);
}
