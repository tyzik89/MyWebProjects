package com.amondin.model.repositories;

import com.amondin.model.entities.Bell;

import java.util.List;

public interface BellRepository {

    void save(Bell bell);

    void delete(Bell bell);

    List<Bell> getAll();

    Bell getById(Long id);
}
