package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.dto.AddJacketDTO;
import org.example.clothingstorespring.dto.AddJacketResponseDTO;
import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.service.JacketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/jackets")
public class JacketController {
    private  static final Logger logger = LoggerFactory.getLogger(OrderController.class);
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


    @PostMapping("/add")

    public ResponseEntity<?> addJacket(@RequestBody @Valid AddJacketDTO jacket) {

        logger.info("Received jacket data: name={}, brand={}, price={}, size={}, material={}, color={}, hasHood={}",
                jacket.getName(), jacket.getBrand(), jacket.getPrice(), jacket.getSize(), jacket.getMaterial(), jacket.getColor(), jacket.isHasHood());

        try {

            AddJacketResponseDTO savedJacket = jacketService.addJacket(jacket);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedJacket);
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



