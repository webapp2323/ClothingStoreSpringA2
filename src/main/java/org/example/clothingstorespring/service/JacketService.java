package org.example.clothingstorespring.service;



import org.example.clothingstorespring.model.Jacket;

import java.util.List;

public interface JacketService {
    Jacket addJacket(Jacket jacket);
    List<Jacket> getAllJacket();
    Jacket getJacketById(Long id);
    void updateJacket(Jacket jacket);
    void deleteJacket(Jacket jacket);
}
