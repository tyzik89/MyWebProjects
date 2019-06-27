package com.amondin.models.repositories;

import com.amondin.models.entities.Bell;

public interface BellRepository {

    Bell save(Bell bell);

    boolean delete(Long id);

    Iterable<Bell> getAll();

    Bell getById(Long id);
}
