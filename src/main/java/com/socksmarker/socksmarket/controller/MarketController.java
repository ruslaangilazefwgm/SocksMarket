package com.socksmarker.socksmarket.controller;

import com.socksmarker.socksmarket.service.MarketService;
import com.socksmarker.socksmarket.model.Sock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@RestController
@RequestMapping("/api/socks")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    // Метод в теле запроса принимает сущность Sock и добавляет ее в базу данных
    @PostMapping("/income")
    public ResponseEntity<Sock> addSocks(@RequestBody Sock sock) {
        marketService.addSocks(sock);
        return ResponseEntity.ok(sock);
    }

    // Метод в теле запроса принимает сущность Sock и удаляет ее из базы данных.
    @DeleteMapping("/outcome")
    public ResponseEntity<Sock> deleteSocks(@RequestBody Sock sock) {
        marketService.removeSocks(sock);
        return ResponseEntity.ok().build();
    }

    //    Метод в строке запроса принимает параметры colour, operation, cottonPart.
    // В зависимости от заданных параметров метод выбирает необходимый условный оператор и возвращает
    // искомый элемент.
    @GetMapping()
    public ResponseEntity<Collection<Sock>> getSocks(@RequestParam("colour") String colour,
                                                     @RequestParam("operation") String operation,
                                                     @RequestParam("cottonPart") Integer cottonPart) {
        if (Objects.equals(operation, "moreThan")) {                        // если ищем Socks, где CottonPart больше переданного значения
            marketService.getSocksWithCottonMoreThan(cottonPart, colour);
        }
        if (Objects.equals(operation, "lessThan")) {                        // если ищем Socks, где CottonPart меньше переданного значения
            marketService.getSocksWithCottonLessThan(cottonPart, colour);
        }
        if (Objects.equals(operation, "equals")) {                          // если ищем Socks, где CottonPart равно переданному значению
            marketService.getSocksWithCottonEquals(cottonPart, colour);
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

}
