package org.example.clothingstorespring.service;



import org.example.clothingstorespring.entity.Pants;
import org.example.clothingstorespring.entity.Shirt;

import java.util.List;

public interface PantsService {
    void addPants(Pants pants);
    List<Pants> getAllPants();
    Pants getPantsById(Long id);
    void updatePants(Pants pants);
    void deletePants(Pants pants);
}
