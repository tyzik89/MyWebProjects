package com.amondin.model.services;

import com.amondin.model.entities.Bell;

import java.util.List;

public interface BellService {

    Bell save(Bell bell);

    void delete(Bell bell);

    List<Bell> getAll();

    Bell findById(Long id);
}
