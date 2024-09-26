package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.entity.Shirt;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShirtController {

    private final ShirtService service;

    public ShirtController(ShirtService service) {
        this.service = service;
    }

    @GetMapping("/shirts")
    public List<Shirt> shirts() {
        return service.getAllShirts();
    }
    @PostMapping("/addShirt")
    public void addShirt(@RequestBody Shirt shirt) {
        service.addShirt(shirt);
    }


}
