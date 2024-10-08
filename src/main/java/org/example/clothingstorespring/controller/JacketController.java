package org.example.clothingstorespring.controller;


import org.example.clothingstorespring.model.Jacket;
import org.example.clothingstorespring.service.JacketService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jackets")
public class JacketController {

    private final JacketService service;// Сервис для управления бизнес-логикой

    public JacketController(JacketService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jacket> getAllJackets() {
        return service.getAllJacket();
    }
    //контроллер которий обрабативает запроси на добавление новой куртки
    @PostMapping("/add")
    //Аннотация @RequestBody:  указывает, что данные из тела HTTP-запроса будут автоматически преобразованы в объект Jacket. Когда клиент (например, Postman) отправляет POST-запрос с JSON-данными, Spring Boot использует Jackson  для десериализации JSON в объект Java.

    //JSON-запрос который  отправляется через Postman:
    //POST http://localhost:8080/jackets/add
    //{
    //"name": "{{$randomFileName}}",
    //"brand": "{{$randomUserName}}",
    //"size": "S",
    //"price": {{$randomPrice}},
    //"material": "COTTON",
    //"hasHood" :true
    //    }
    //Jackson: Это библиотека, которая обычно используется в Spring Boot для преобразования JSON в Java-объекты. Она автоматически связывает поля JSON с соответствующими полями класса Jacket.
    //поле name в JSON будет сопоставлено с полем name в классе public abstract class ClothingItem ...
    //После того как объект Jacket будет создан, контроллер передаст его в сервис, который сохранит его в базе данных:
    public void addJacket(@RequestBody Jacket jacket) {
        service.addJacket(jacket);
    }

    @GetMapping("/{id}")
    public Jacket getJacketById(@PathVariable Long id) {
        return service.getJacketById(id);
    }

    @PutMapping("/update")
    public void updateJacket(@RequestBody Jacket jacket) {
        service.updateJacket(jacket);
    }

    @DeleteMapping("/delete")
    public void deleteJacket(@RequestBody Jacket jacket) {
        service.deleteJacket(jacket);
    }
}



