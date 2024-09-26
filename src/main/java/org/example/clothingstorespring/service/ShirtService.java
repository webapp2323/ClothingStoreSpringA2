package org.example.clothingstorespring.service;



import org.example.clothingstorespring.entity.Shirt;

import java.util.List;

public interface ShirtService {
    void addShirt(Shirt shirt);
    List<Shirt> getAllShirts();
    Shirt getShirtById(Long id);
    void updateShirt(Shirt shirt);
    void deleteShirt(Shirt shirt);
}
