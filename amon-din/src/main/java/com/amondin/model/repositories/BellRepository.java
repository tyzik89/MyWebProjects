package com.amondin.model.repositories;

import com.amondin.model.entities.Bell;

import java.util.List;

public interface BellRepository {

    Bell save(Bell bell);

    boolean delete(Long id);

    Iterable<Bell> getAll();

    Bell getById(Long id);
}
