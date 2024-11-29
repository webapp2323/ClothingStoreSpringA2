package org.example.clothingstorespring.controller;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.example.clothingstorespring.dto.AddShirtDTO;
import org.example.clothingstorespring.dto.AddShirtResponseDTO;
import org.example.clothingstorespring.model.Pants;
import org.example.clothingstorespring.model.Shirt;
import org.example.clothingstorespring.service.ShirtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/shirts")
@AllArgsConstructor
public class ShirtController {

    private final ShirtService shirtService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/add")
    public ResponseEntity<?> addShirt(@RequestBody AddShirtDTO shirtDTO) {

        logger.info("Received shirt data: name={}, brand={}, price={}, size={}, material={}, color={},sleeve_type={}",
                shirtDTO.getName(),
                shirtDTO.getBrand(),
                shirtDTO.getPrice(),
                shirtDTO.getSize(),
                shirtDTO.getMaterial(),
                shirtDTO.getColor(),
                shirtDTO.getSleeve_type());

        try {
            AddShirtResponseDTO savedShirt = shirtService.addShirt(shirtDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedShirt);

        } catch (IllegalArgumentException e) {
            logger.error("Ошибка при добавлении куртки: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Validation error: " + e.getMessage()));

        } catch (Exception e) {
            logger.error("Неизвестная ошибка: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Internal server error: " + e.getMessage()));
        }
    }
}

//    @GetMapping("/{id}")
//    public ResponseEntity<Shirt> getShirtById(@PathVariable Long id) {
//        log.info("Received request to get shirt by id: {}", id);
//
//        Optional<Shirt> shirt = shirtService.getShirtById(id);
//
//        return shirt.map(s -> {
//            log.info("Shirt found: {}", s);
//            return ResponseEntity.ok(s);
//        }).orElseGet(() -> {
//            log.warn("Shirt not found for id: {}", id);
//            return ResponseEntity.notFound().build();
//        });
//    }
//
//
//    @PutMapping("/update_shirt")
//    public ResponseEntity<Void> updateShirt(@RequestBody Shirt shirt) {
//        log.info("Received request to update shirt: {}", shirt);
//        try {
//            shirtService.updateShirt(shirt);
//            log.info("Shirt updated successfully: {}", shirt);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            log.error("Error updating shirt: {}", e.getMessage());
//            return ResponseEntity.status(500).build();
//        }
//    }
//
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> deleteShirts(@RequestBody List<Integer> ids) {
//        // Логируем информацию о полученных идентификаторах
//        log.info("Received request to delete shirts with ids: {}", ids);
//
//        try {
//            for (Integer id : ids) {
//                shirtService.deleteShirt(Long.valueOf(id)); // Удаление каждой рубашки по идентификатору
//                log.info("Shirt with id {} successfully deleted", id); // Логируем успешное удаление
//            }
//
//            log.info("200 OK: Request successful. The server has responded as required.");
//            return ResponseEntity.ok().build(); // Возвращаем 200 OK
//        } catch (Exception e) {
//            log.error("Error deleting shirts: {}", e.getMessage());
//            return ResponseEntity.status(500).build(); // Возвращаем 500 Internal Server Error
//        }
//    }
//
//}

