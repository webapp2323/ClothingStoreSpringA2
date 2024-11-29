package org.example.clothingstorespring.service;



import org.example.clothingstorespring.dto.AddShirtDTO;
import org.example.clothingstorespring.dto.AddShirtResponseDTO;
import org.example.clothingstorespring.model.Shirt;

import java.util.List;
import java.util.Optional;

public interface ShirtService {

    List<Shirt> getAllShirts();

    // Метод Optional<Shirt> getShirtById(Long id); возвращает объект типа Shirt, обернутый в Optional, что позволяет безопасно обрабатывать ситуации, когда объект может отсутствовать. Это улучшает читаемость и надежность кода, избегая распространенных ошибок, связанных с null.
    Optional<Shirt> getShirtById(Long id);



    AddShirtResponseDTO addShirt(AddShirtDTO shirtDTO);

    Shirt updateShirt(Shirt shirt);

    // Удаляет рубашку по идентификатору
    void deleteShirt(Long id);

    List<Shirt> getShirtsByIds(List<Long> ids);
}
