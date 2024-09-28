package org.example.clothingstorespring.controller;


import lombok.AllArgsConstructor;
import org.example.clothingstorespring.model.Shirt;
//import org.example.clothingstorespring.service.ShirtService;
//import org.example.clothingstorespring.service.ShirtService;
import org.example.clothingstorespring.service.impl.ShirtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/shirts")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ShirtController {


    private final ShirtServiceImpl service;

//    public ShirtController(ShirtService service) {
//        this.service = service;
//    }

//    @GetMapping
//    public List<Shirt> getAllShirts() {
//        return service.getAllShirts();
//    }

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

    @PutMapping("/update_shirt")
    public void updateShirt(Shirt shirt) {
        service.updateShirt(shirt);
    }

    @DeleteMapping("/delete_shirt/{id}")
    public void deleteShirt(@PathVariable Shirt id) {
        service.deleteShirt(id);
    }
}


