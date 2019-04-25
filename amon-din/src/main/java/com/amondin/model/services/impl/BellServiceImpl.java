package com.amondin.model.services.impl;

import com.amondin.model.entities.Bell;
import com.amondin.model.repositories.BellRepository;
import com.amondin.model.services.BellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BellServiceImpl implements BellService {

    @Autowired
    @Qualifier("jdbc_repository")
    private BellRepository bellRepository;

    @Override
    public Bell save(Bell bell) {
        bellRepository.save(bell);
        return bell;
    }

    @Override
    public Bell delete(Bell bell) {
        return bell;
    }

    @Override
    public Iterable<Bell> getAll() {
        return bellRepository.getAll();
    }

    @Override
    public Bell findById(Long id) {
        return bellRepository.getById(id);
    }
}
