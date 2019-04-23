package com.amondin.model.services;

import com.amondin.model.entities.Bell;

public interface BellService {

    Bell save(Bell bell);

    Bell delete(Bell bell);

    Iterable<Bell> getAll();

    Bell findById(Long id);
}
