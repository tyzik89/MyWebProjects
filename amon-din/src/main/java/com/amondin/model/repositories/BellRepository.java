package com.amondin.model.repositories;

import com.amondin.model.entities.Bell;

import java.util.List;

public interface BellRepository {

    Bell save(Bell bell);

    Bell delete(Bell bell);

    Iterable<Bell> getAll();

    Bell getById(Long id);
}
