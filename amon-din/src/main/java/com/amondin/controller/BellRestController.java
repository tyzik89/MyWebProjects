package com.amondin.controller;

import com.amondin.model.entities.Bell;
import com.amondin.model.services.BellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class BellRestController {

    @Autowired
    BellService bellService;

    @GetMapping("/bells")
    public Iterable<Bell> findAllBells() {
        return bellService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/bells")
    public Bell newBell(@RequestBody Bell newBell) {
        return bellService.save(newBell);
    }

    @GetMapping("/bells/{id}")
    public Bell findBellById(@PathVariable Long id) {
        return bellService.findById(id);
    }
}
