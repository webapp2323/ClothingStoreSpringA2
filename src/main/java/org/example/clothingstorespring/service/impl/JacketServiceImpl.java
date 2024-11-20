package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.repository.JacketRepository;
import org.example.clothingstorespring.service.JacketService;
import org.springframework.stereotype.Service;

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
    public Jacket addJacket(Jacket jacket) {

        jacketRepository.save(jacket);
        return jacket;
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
