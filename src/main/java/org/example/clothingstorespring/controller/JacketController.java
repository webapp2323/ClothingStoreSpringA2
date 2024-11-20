package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.service.JacketService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jackets")
public class JacketController {

    private final JacketService jacketService; // Убедитесь, что название переменной совпадает

    // Конструктор для внедрения зависимости
    public JacketController(JacketService jacketService) {
        this.jacketService = jacketService;
    }

    // Получение всех курток
    @GetMapping
    public List<Jacket> getAllJackets() {
        return jacketService.getAllJacket(); // Используем jacketService
    }

    // Контроллер, который обрабатывает запросы на добавление новой куртки
    @PostMapping("/add")
    public ResponseEntity<Jacket> addJacket(@RequestBody Jacket jacket) {
        try {
            Jacket savedJacket = jacketService.addJacket(jacket);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedJacket);
        } catch (Exception e) {
            e.printStackTrace(); // Вывод ошибки в консоль
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
//    @GetMapping("/{id}")
//    public Jacket getJacketById(@PathVariable Long id) {
//        return service.getJacketById(id);
//    }
//
//    @PutMapping("/update")
//    public void updateJacket(@RequestBody Jacket jacket) {
//        service.updateJacket(jacket);
//    }
//
//    @DeleteMapping("/delete")
//    public void deleteJacket(@RequestBody Jacket jacket) {
//        service.deleteJacket(jacket);
//    }
//}



