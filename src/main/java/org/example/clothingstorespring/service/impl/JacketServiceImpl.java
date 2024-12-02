package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.dto.AddJacketDTO;
import org.example.clothingstorespring.dto.AddJacketResponseDTO;
import org.example.clothingstorespring.model.Brand;
import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.model.Size;
import org.example.clothingstorespring.repository.JacketRepository;
import org.example.clothingstorespring.service.JacketService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
//@Service: Аннотация, которая указывает, что класс является сервисом, и Spring будет управлять его жизненным циклом.
public class JacketServiceImpl implements JacketService {

    private final JacketRepository jacketRepository;

    public JacketServiceImpl(JacketRepository jacketRepository) {
        this.jacketRepository = jacketRepository;
    }

//Сохраняет объект Jacket в базе данных, используя репозиторий. Метод возвращает сохраненный объект.

    @Override
    public AddJacketResponseDTO addJacket(AddJacketDTO jacketDTO) {

        // Проверка валидности входных данных
        if (jacketDTO.getName() == null || jacketDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (jacketDTO.getBrand() == null || jacketDTO.getBrand().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (jacketDTO.getPrice() == null || jacketDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (jacketDTO.getSize() == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        if (jacketDTO.getMaterial() == null) {
            throw new IllegalArgumentException("Material cannot be null");
        }
        if (jacketDTO.getColor() == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }

        Jacket jacket = new Jacket();
        // Установка значения name
        jacket.setName(jacketDTO.getName()); // Добавлено
        jacket.setMaterial(String.valueOf(jacketDTO.getMaterial()));
        jacket.setPrice(jacketDTO.getPrice());
        jacket.setBrand(Brand.valueOf(jacketDTO.getBrand()));
        jacket.setColor(String.valueOf(jacketDTO.getColor()));
        jacket.setSize(Size.valueOf(String.valueOf(jacketDTO.getSize())));
        jacket.setHasHood(jacketDTO.isHasHood()); // Исправлено: убедитесь, что используете правильное имя метода

        // Сохранение куртки в репозитории
        jacketRepository.save(jacket);

        // Создание объекта ответа с корректными данными
        AddJacketResponseDTO responseDTO = new AddJacketResponseDTO();
        responseDTO.setId(jacket.getId());
        responseDTO.setName(jacketDTO.getName());
        responseDTO.setMaterial(String.valueOf(jacketDTO.getMaterial()));
        responseDTO.setColor(String.valueOf(jacketDTO.getColor()));
        responseDTO.setSize(String.valueOf(jacketDTO.getSize()));
        responseDTO.setBrand(jacketDTO.getBrand());
        responseDTO.setPrice(jacketDTO.getPrice());
        responseDTO.setHasHood(jacketDTO.isHasHood());

        responseDTO.setMessage("Jacket added successfully!");
        return responseDTO;
    }

    @Override
    public List<Jacket> getAllJacket() {
        return jacketRepository.findAll();
    }




    @Override
    public Jacket getJacketById(Long id) {
        return jacketRepository.findById(id).orElse(null);
    }

    @Override
    public void updateJacket(Jacket jacket) {
        jacketRepository.save(jacket);
    }

    @Override
    public void deleteJacket(Jacket jacket) {
        jacketRepository.delete(jacket);
    }
}
