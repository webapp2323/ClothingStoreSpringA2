package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.entity.Jacket;
import org.example.clothingstorespring.service.JacketService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JacketController {

    private final JacketService service;

    public JacketController(JacketService service) {
        this.service = service;
    }

    @GetMapping("/jackets")
    public List<Jacket> jackets() {
        return service.getAllJacket();
    }
    @PostMapping("/addJacket")
    public void addJacket(@RequestBody Jacket jacket) {
        service.addJacket(jacket);
    }


}
