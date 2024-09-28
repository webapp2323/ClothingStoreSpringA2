package org.example.clothingstorespring.service.impl;


import org.example.clothingstorespring.model.Pants;
import org.example.clothingstorespring.repository.PantsRepository;
import org.example.clothingstorespring.service.PantsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantsServiceImpl implements PantsService {

    private final PantsRepository pantsRepository;

    public PantsServiceImpl(PantsRepository pantsRepository) {this.pantsRepository = pantsRepository;

    }

    @Override
    public void addPants(Pants pants) {
        pantsRepository.save(pants);
    }

    @Override
    public List<Pants> getAllPants() {
        return pantsRepository.findAll();
    }

    @Override
    public Pants getPantsById(Long id) {
        return pantsRepository.findById(id).orElse(null);
    }

    @Override
    public void updatePants(Pants pants) {
        pantsRepository.save(pants);
    }

    @Override
    public void deletePants(Pants pants) {
        pantsRepository.delete(pants);
    }



}
