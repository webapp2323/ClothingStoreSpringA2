package org.example.clothingstorespring.service;



import org.example.clothingstorespring.model.Pants;

import java.util.List;

public interface PantsService {
    Pants addPants(Pants pants);
    List<Pants> getAllPants();
    Pants getPantsById(Long id);
    void updatePants(Pants pants);
    void deletePants(Pants pants);
}
