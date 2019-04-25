package com.amondin.controller;

import com.amondin.model.entities.Bell;
import com.amondin.model.services.BellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/bells")
public class BellRestController {

    @Autowired
    BellService bellService;

    @GetMapping()
    public Iterable<Bell> findAllBells() {
        return bellService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
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
