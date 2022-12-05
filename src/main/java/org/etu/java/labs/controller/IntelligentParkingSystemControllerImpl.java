package org.etu.java.labs.controller;

import org.etu.java.labs.entity.IntelligentParkingSystem;
import org.etu.java.labs.service.IntelligentParkingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("intelligent-parking-system")
public class IntelligentParkingSystemControllerImpl implements IntelligentParkingSystemController {
    @Autowired
    private IntelligentParkingSystemService service;


    @Override
    public ResponseEntity<List<IntelligentParkingSystem>> getAll(Locale locale) {
        return ResponseEntity.ok(service.getAll(locale));
    }

    @Override
    public ResponseEntity<IntelligentParkingSystem> getById(String id, Locale locale) {
        var item = service.getById(id, locale);

        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> create(IntelligentParkingSystem item, Locale locale) {
        return ResponseEntity.ok(service.create(item, locale));
    }

    @Override
    public ResponseEntity<String> update(IntelligentParkingSystem item, Locale locale) {
        return ResponseEntity.ok(service.update(item, locale));
    }

    @Override
    public ResponseEntity<String> delete(String id, Locale locale) {
        return ResponseEntity.ok(service.delete(id, locale));
    }
}
