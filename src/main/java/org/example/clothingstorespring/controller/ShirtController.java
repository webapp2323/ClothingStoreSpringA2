package org.example.clothingstorespring.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.model.Shirt;
import org.example.clothingstorespring.service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/* POST http://localhost:8080/api/v1/shirts/add
 {
    "name": "Lightweight Shirt",
    "brand": "Brand F",
    "price": 24.99,
    "sleeve_Type": "LONG",
    "size": "S",
    "material": "LINEN"
}
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/shirts")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ShirtController {

    private final ShirtService shirtService;

    @GetMapping
    public ResponseEntity<List<Shirt>> getAllShirts() {
        log.info("Received request to get all shirts");
        List<Shirt> shirts = shirtService.getAllShirts();
        log.info("Returning {} shirts", shirts.size());
        return ResponseEntity.ok(shirts);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addShirt(@RequestBody Shirt shirt) {
        // Логируем информацию о полученной рубашке
        log.info("Received request to add shirt: {}", shirt);

        try {
            shirtService.addShirt(shirt); // Добавление рубашки в сервис
            log.info("Shirt successfully added: {}", shirt); // Логируем успешное добавление
            log.info("200 OK: Request successful. The server has responded as required.");
            return ResponseEntity.ok().build(); // Возвращаем 200 OK
        } catch (Exception e) {
            log.error("Error adding shirt: {}", e.getMessage());
            return ResponseEntity.status(500).build(); // Возвращаем 500 Internal Server Error
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shirt>> getShirtById(@PathVariable Long id) {
        log.info("Received request to get shirt by id: {}", id);
        Optional<Shirt> shirt = shirtService.getShirtById(id);
        if (shirt.isPresent()) {
            log.info("Shirt found: {}", shirt.get());
            return ResponseEntity.ok(shirt);
        } else {
            log.warn("Shirt not found for id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update_shirt")
    public ResponseEntity<Void> updateShirt(@RequestBody Shirt shirt) {
        log.info("Received request to update shirt: {}", shirt);
        try {
            shirtService.updateShirt(shirt);
            log.info("Shirt updated successfully: {}", shirt);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error updating shirt: {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteShirt(@RequestBody Shirt shirt) {
        log.info("Received request to delete shirt: {}", shirt);
        try {
            shirtService.deleteShirt(shirt);
            log.info("Shirt deleted successfully: {}", shirt);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error deleting shirt: {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}