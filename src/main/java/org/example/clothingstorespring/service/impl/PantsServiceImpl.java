package org.example.clothingstorespring.service.impl;


import org.example.clothingstorespring.dto.AddPantsDTO;
import org.example.clothingstorespring.dto.AddPantsResponseDTO;
import org.example.clothingstorespring.model.Brand;
import org.example.clothingstorespring.model.Color;
import org.example.clothingstorespring.model.Pants;
import org.example.clothingstorespring.model.Size;
import org.example.clothingstorespring.repository.PantsRepository;
import org.example.clothingstorespring.service.PantsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PantsServiceImpl implements PantsService {

    private final PantsRepository pantsRepository;

    public PantsServiceImpl(PantsRepository pantsRepository) {
        this.pantsRepository = pantsRepository;

    }

    //    @Override
//    public void addPants(Pants pants) {
//        pantsRepository.save(pants);
//    }
    @Override
    public AddPantsResponseDTO addPants(AddPantsDTO pantsDTO) {

        // Проверка валидности входных данных
        if (pantsDTO.getName() == null || pantsDTO
                .getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (pantsDTO.getBrand() == null || pantsDTO
                .getBrand().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (pantsDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (pantsDTO.getSize() == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        if (pantsDTO.getMaterial() == null) {
            throw new IllegalArgumentException("Material cannot be null");
        }
        if (pantsDTO.getColor() == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }

        Pants pants = new Pants();
        // Установка значения name
        pants.setName(pantsDTO.getName()); // Добавлено
        pants.setMaterial(pantsDTO.getMaterial());
        pants.setPrice(pantsDTO.getPrice());
        pants.setBrand(Brand.valueOf(pantsDTO.getBrand()));
        pants.setColor(Color.valueOf(pantsDTO.getColor()));
        pants.setSize(pantsDTO.getSize());


        // Сохранение штанов в репозитории
        pantsRepository.save(pants);

        // Создание объекта ответа с корректными данными
        AddPantsResponseDTO responseDTO = new AddPantsResponseDTO();
        responseDTO.setId(pants.getId());
        responseDTO.setName(pantsDTO.getName());
        responseDTO.setMaterial(pantsDTO.getMaterial());
        responseDTO.setColor(Color.valueOf(pantsDTO.getColor()));
        responseDTO.setSize(pantsDTO.getSize());
        responseDTO.setBrand(pantsDTO.getBrand());
        responseDTO.setPrice(pantsDTO.getPrice());


        responseDTO.setMessage("Pants added successfully!");
        return responseDTO;
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
