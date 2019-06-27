package com.amondin.controllers;

import com.amondin.models.entities.Bell;
import com.amondin.models.services.BellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/bells")
public class BellRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BellRestController.class);

    @Autowired
    BellService bellService;

    @GetMapping
    public Iterable<Bell> findAllBells() {
        return bellService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Bell newBell(@RequestBody Bell newBell) {
        return bellService.save(newBell);
    }

    @GetMapping("/{id}")
    public Bell findBellById(@PathVariable Long id) {
        return bellService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBellById(@PathVariable Long id) {
            return bellService.delete(id)? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();
    }
}
