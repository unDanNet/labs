package org.etu.java.labs.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.etu.java.labs.entity.IntelligentParkingSystem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

public interface IntelligentParkingSystemController {
    @GetMapping("/all")
    ResponseEntity<List<IntelligentParkingSystem>> getAll(
        @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale
    );

    @GetMapping("/{id}")
    ResponseEntity<IntelligentParkingSystem> getById(
        @PathVariable String id,
        @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale
    );

    @PutMapping("/add")
    ResponseEntity<String> create(
        @RequestBody IntelligentParkingSystem item,
        @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale
    );

    @PostMapping("/update")
    ResponseEntity<String> update(
        @RequestBody IntelligentParkingSystem item,
        @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale
    );

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(
        @PathVariable String id,
        @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale
    );
}
