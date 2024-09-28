package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.entity.Pants;
import org.example.clothingstorespring.service.PantsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pants")
public class PantsController {

    private final PantsService service;



    public PantsController(PantsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pants> getAllPants() {
        return service.getAllPants();
    }

    @PostMapping("/add")
    public void addPants(@RequestBody Pants pants) {
        service.addPants(pants);
    }

    @GetMapping("/{id}")
    public Pants getPantsById(@PathVariable Long id) {
        return service.getPantsById(id);
    }

    @PutMapping("/update")
    public void updatePants(@RequestBody Pants pants) {
        service.updatePants(pants);
    }

    @DeleteMapping("/delete")
    public void deletePants(@RequestBody Pants pants) {
        service.deletePants(pants);
    }
}
