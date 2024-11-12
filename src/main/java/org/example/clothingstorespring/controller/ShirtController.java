package org.example.clothingstorespring.controller;

import lombok.AllArgsConstructor;
import lombok.ToString;
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
@ToString
@RestController
@RequestMapping("/api/v1/shirts")
@AllArgsConstructor
public class ShirtController {

    private final ShirtService shirtService;

    @GetMapping
    public ResponseEntity<List<Shirt>> getAllShirts() {
        log.info("Received request to get all shirts");
        List<Shirt> shirts = shirtService.getAllShirts();
        log.info("Returning {} shirts", Optional.of(shirts.size()));
        return ResponseEntity.ok(shirts);
    }



    @GetMapping("/search")
    public ResponseEntity<List<Shirt>> getShirtsByIds(@RequestParam List<Long> ids) {
        log.info("Received request to get shirts by ids: {}", ids);

        if (ids.isEmpty()) {
            log.warn("No ids provided in the request.");
            return ResponseEntity.badRequest().body(null);
        }

        List<Shirt> shirts = shirtService.getShirtsByIds(ids);

        if (shirts.isEmpty()) {
            log.info("No shirts found for the provided ids: {}", ids);
            return ResponseEntity.notFound().build();
        }

        // Логируем информацию о каждой найденной рубашке
        for (Shirt shirt : shirts) {
            log.info("Shirt found: {}", shirt);
        }

        log.info("Found {} shirts for the provided ids: {}", Optional.of(Optional.of(shirts.size())), ids);
 
        return ResponseEntity.ok(shirts);
    }



    @PostMapping("/add")
    public ResponseEntity<Void> addShirts(@RequestBody List<Shirt> shirts) {
        // Логируем информацию о полученных рубашках
        log.info("Received request to add shirts: {}", shirts);

        try {
            for (Shirt shirt : shirts) {
                shirtService.addShirt(shirt); // Добавление каждой рубашки в сервис
                log.info("Shirt successfully added: {}", shirt); // Логируем успешное добавление каждой рубашки
            }

            log.info("200 OK: Request successful. The server has responded as required.");
            return ResponseEntity.ok().build(); // Возвращаем 200 OK
        } catch (Exception e) {
            log.error("Error adding shirts: {}", e.getMessage());
            return ResponseEntity.status(500).build(); // Возвращаем 500 Internal Server Error
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Shirt> getShirtById(@PathVariable Long id) {
        log.info("Received request to get shirt by id: {}", id);

        Optional<Shirt> shirt = shirtService.getShirtById(id);

        return shirt.map(s -> {
            log.info("Shirt found: {}", s);
            return ResponseEntity.ok(s);
        }).orElseGet(() -> {
            log.warn("Shirt not found for id: {}", id);
            return ResponseEntity.notFound().build();
        });
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
    public ResponseEntity<Void> deleteShirts(@RequestBody List<Integer> ids) {
        // Логируем информацию о полученных идентификаторах
        log.info("Received request to delete shirts with ids: {}", ids);

        try {
            for (Integer id : ids) {
                shirtService.deleteShirt(Long.valueOf(id)); // Удаление каждой рубашки по идентификатору
                log.info("Shirt with id {} successfully deleted", id); // Логируем успешное удаление
            }

            log.info("200 OK: Request successful. The server has responded as required.");
            return ResponseEntity.ok().build(); // Возвращаем 200 OK
        } catch (Exception e) {
            log.error("Error deleting shirts: {}", e.getMessage());
            return ResponseEntity.status(500).build(); // Возвращаем 500 Internal Server Error
        }
    }

}

