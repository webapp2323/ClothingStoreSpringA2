package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.model.Pants;
import org.example.clothingstorespring.service.PantsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pants")
public class PantsController {


    private final PantsService pantsService;


    public PantsController(PantsService pantsService) {
        this.pantsService = pantsService;
    }


//    @GetMapping
//    public List<Pants> getAllPants() {
//        return service.getAllPants();
//    }

//    @PostMapping("/add")
//    public void addPants(@RequestBody Pants pants) {
//        service.addPants(pants);
//    }

    @PostMapping("/add")
    public ResponseEntity<Pants> addPants(@RequestBody Pants pants) {
        try {
            Pants savedPants = pantsService.addPants(pants);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPants);
        } catch (Exception e) {
            e.printStackTrace(); // Вывод ошибки в консоль
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

//@GetMapping("/{id}")
//public Pants getPantsById(@PathVariable Long id) {
//    return service.getPantsById(id);
//}
//
//@PutMapping("/update")
//public void updatePants(@RequestBody Pants pants) {
//    service.updatePants(pants);
//}
//
//@DeleteMapping("/delete")
//public void deletePants(@RequestBody Pants pants) {
//    service.deletePants(pants);
//}
//}
