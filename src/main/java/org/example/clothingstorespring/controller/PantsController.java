package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.dto.AddPantsDTO;

import org.example.clothingstorespring.dto.AddPantsResponseDTO;

import org.example.clothingstorespring.service.PantsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/pants")
public class PantsController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final PantsService pantsService;


    public PantsController(PantsService pantsService) {
        this.pantsService = pantsService;
    }


//    @GetMapping
//    public List<Pants> getAllPants() {
//        return service.getAllPants();
//    }


    @PostMapping("/add")
    public ResponseEntity<?> addPants(@RequestBody AddPantsDTO pantsDTO) {

        logger.info("Received pants data: name={}, brand={}, price={}, size={}, material={}, color={}",
                pantsDTO.getName(),
                pantsDTO.getBrand(),
                pantsDTO.getPrice(),
                pantsDTO.getSize(),
                pantsDTO.getMaterial(),
                pantsDTO.getColor());

        try {
            AddPantsResponseDTO savedPants = pantsService.addPants(pantsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPants);

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
