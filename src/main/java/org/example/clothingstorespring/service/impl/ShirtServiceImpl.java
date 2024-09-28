package org.example.clothingstorespring.service.impl;


import lombok.AllArgsConstructor;
import org.example.clothingstorespring.model.Shirt;

import org.example.clothingstorespring.repository.InMemoryShirt;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShirtServiceImpl implements ShirtService {

@Autowired
    private final InMemoryShirt shirtRepository;

    //
//    public ShirtServiceImpl(ShirtRepository shirtRepository) {
//        this.shirtRepository = shirtRepository;
//    }
//
//    @Override
//    public void addShirt(Shirt shirt) {
//        shirtRepository.save(shirt);
//    }
    public List<Shirt> getAllShirts() {
        return shirtRepository.getAllShirts();

        //        return List.of(
//                Shirt.builder().brand("Gusssss").price(66.00).size("L").sleeveType(SleeveType.THREEQUARTER).name("spring-Gusssss").build(),
//                Shirt.builder().brand("Polo").price(12.222).size("M").sleeveType(SleeveType.SHORT).name("spring-Nike T-Shirttttt").build(),
//                Shirt.builder().brand("Geoxxxxx").price(120.12).size("S").sleeveType(SleeveType.LONG).name("springGeox").build()
//        );

//    @Override
//    public List<Shirt> getAllShirts() {
//        return shirtRepository.findAll();
//    }

//    @Override
//    public Shirt getShirtById(double id) {
//        return shirtRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void updateShirt(Shirt shirt) {
//        shirtRepository.save(shirt);
//    }
//
//    @Override
//    public void deleteShirt(Shirt shirt) {
//        shirtRepository.delete(shirt);
//    }


    }

    @Override
    public Shirt getShirtById(Long id) {
        return shirtRepository.getShirtById(id);
    }

    @Override
    public Shirt addShirt(Shirt shirt) {
        return shirtRepository.addShirt(shirt);
    }

    @Override
    public Shirt updateShirt(Shirt shirt) {
        return shirtRepository.updateShirt(shirt);

    }

    @Override
    public void deleteShirt(Shirt shirt) {
        shirtRepository.deleteShirt(shirt);

    }
}
