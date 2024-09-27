package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.entity.Pants;
import org.example.clothingstorespring.service.PantsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PantsController {

    private final PantsService service;



    public PantsController(PantsService service) {
        this.service = service;
    }

    @GetMapping("/pants")
    public List<Pants> pants() {
        return service.getAllPants();
    }
    @PostMapping("/addPants")
    public void addPants(@RequestBody Pants pants) {
        service.addPants(pants);
    }


}
