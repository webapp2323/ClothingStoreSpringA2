package org.example.clothingstorespring.service;



import org.example.clothingstorespring.dto.AddPantsDTO;
import org.example.clothingstorespring.dto.AddPantsResponseDTO;
import org.example.clothingstorespring.model.Pants;

import java.util.List;

public interface PantsService {
    AddPantsResponseDTO addPants(AddPantsDTO pantsDTO);
    List<Pants> getAllPants();
    Pants getPantsById(Long id);
    void updatePants(Pants pants);
    void deletePants(Pants pants);

}
