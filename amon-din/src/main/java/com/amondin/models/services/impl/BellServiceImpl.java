package com.amondin.models.services.impl;

import com.amondin.models.entities.Bell;
import com.amondin.models.repositories.BellRepository;
import com.amondin.models.services.BellService;
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
    public boolean delete(Long id) {
        return bellRepository.delete(id);
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
