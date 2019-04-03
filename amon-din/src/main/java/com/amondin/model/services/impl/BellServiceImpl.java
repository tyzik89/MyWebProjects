package com.amondin.model.services.impl;

import com.amondin.model.entities.Bell;
import com.amondin.model.repositories.BellRepository;
import com.amondin.model.services.BellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BellServiceImpl implements BellService {

    @Autowired
    private BellRepository bellRepository;

    @Override
    public Bell save(Bell bell) {
        bellRepository.save(bell);
        return bell;
    }

    @Override
    public void delete(Bell bell) {

    }

    @Override
    public List<Bell> getAll() {
        return bellRepository.getAll();
    }

    @Override
    public Bell findById(Long id) {
        return bellRepository.getById(id);
    }
}
