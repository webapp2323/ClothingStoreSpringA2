package org.example.clothingstorespring.controller;


import lombok.AllArgsConstructor;
import org.example.clothingstorespring.model.Shirt;
//import org.example.clothingstorespring.service.ShirtService;
//import org.example.clothingstorespring.service.ShirtService;
import org.example.clothingstorespring.service.ShirtService;
import org.example.clothingstorespring.service.impl.ShirtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/shirts")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ShirtController {


    @Autowired
    private ShirtService shirtService;

    @GetMapping
    public List<Shirt> getAllShirts() {
        return shirtService.getAllShirts();
    }

    @PostMapping("/add")
    public void addShirt(@RequestBody Shirt shirt) {
        shirtService.addShirt(shirt);
    }

    @GetMapping("/{id}")
    public Optional<Shirt> getShirtById(@PathVariable Long id) {
        return shirtService.getShirtById(id);
    }

    @PutMapping("/update_shirt")
    public void updateShirt(@RequestBody Shirt shirt) {
        shirtService.updateShirt(shirt);
    }

    @DeleteMapping("/delete")
    public void deleteShirt(@RequestBody Shirt shirt) {
        shirtService.deleteShirt(shirt);
    }
}


