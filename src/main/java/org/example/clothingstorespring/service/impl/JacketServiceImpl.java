package org.example.clothingstorespring.service.impl;

import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.repository.JacketRepository;
import org.example.clothingstorespring.service.JacketService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addJacket(Jacket jacket) {//автоматически используют указанные типы.
        //В Spring Data JPA метод save() интерфейса JpaRepository позволяет сохранять объект в базе данных.
        //Передача объекта:
        // Когда вы вызываете jacketRepository.save(jacket), вы передаете объект Jacket, который хотите сохранить в базе данных.
        //Обработка JPA:
        //Если объект jacket не имеет установленного идентификатора (т.е. это новая сущность), JPA создаст новую запись в базе данных.
        //Если у объекта jacket уже есть идентификатор, JPA найдет соответствующую запись в базе данных и обновит её поля значениями из объекта jacket.
        jacketRepository.save(jacket);// Сохранение куртки в базе данных
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
