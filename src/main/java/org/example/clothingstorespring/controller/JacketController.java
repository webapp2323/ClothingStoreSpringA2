package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.entity.Jacket;
import org.example.clothingstorespring.service.JacketService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jackets")
public class JacketController {

    private final JacketService service;

    public JacketController(JacketService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jacket> getAllJackets() {
        return service.getAllJacket();
    }

    @PostMapping("/add")
    public void addJacket(@RequestBody Jacket jacket) {
        service.addJacket(jacket);
    }

    @GetMapping("/{id}")
    public Jacket getJacketById(@PathVariable Long id) {
        return service.getJacketById(id);
    }

    @PutMapping("/update")
    public void updateJacket(@RequestBody Jacket jacket) {
        service.updateJacket(jacket);
    }

    @DeleteMapping("/delete")
    public void deleteJacket(@RequestBody Jacket jacket) {
        service.deleteJacket(jacket);
    }
}



