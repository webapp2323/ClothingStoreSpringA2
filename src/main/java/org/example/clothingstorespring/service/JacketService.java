package org.example.clothingstorespring.service;



import org.example.clothingstorespring.dto.AddJacketDTO;
import org.example.clothingstorespring.dto.AddJacketResponseDTO;
import org.example.clothingstorespring.model.Jacket;

import java.util.List;

public interface JacketService {
    AddJacketResponseDTO addJacket(AddJacketDTO jacketDTO);
    List<Jacket> getAllJacket();
    Jacket getJacketById(Long id);
    void updateJacket(Jacket jacket);
    void deleteJacket(Jacket jacket);
}
