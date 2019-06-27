package com.amondin.models.services;

import com.amondin.models.entities.Bell;

public interface BellService {

    Bell save(Bell bell);

    boolean delete(Long id);

    Iterable<Bell> getAll();

    Bell findById(Long id);
}
