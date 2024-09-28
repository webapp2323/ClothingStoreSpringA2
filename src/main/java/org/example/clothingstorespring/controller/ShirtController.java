package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.entity.Shirt;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shirts")
public class ShirtController {

    private final ShirtService service;

    public ShirtController(ShirtService service) {
        this.service = service;
    }

    @GetMapping
    public List<Shirt> getAllShirts() {
        return service.getAllShirts();
    }

    @PostMapping("/add")
    public void addShirt(@RequestBody Shirt shirt) {
        service.addShirt(shirt);
    }

    @GetMapping("/{id}")
    public Shirt getShirtById(@PathVariable Long id) {
        return service.getShirtById(id);
    }

    @PutMapping("/update")
    public void updateShirt(@RequestBody Shirt shirt) {
        service.updateShirt(shirt);
    }

    @DeleteMapping("/delete")
    public void deleteShirt(@RequestBody Shirt shirt) {
        service.deleteShirt(shirt);
    }
}

