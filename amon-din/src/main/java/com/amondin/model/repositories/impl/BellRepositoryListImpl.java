package com.amondin.model.repositories.impl;

import com.amondin.model.entities.Bell;
import com.amondin.model.repositories.BellRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BellRepositoryListImpl implements BellRepository {

    private List<Bell> bellList = new ArrayList<Bell>();

    @Override
    public void save(Bell bell) {
        bellList.add(bell);
    }

    @Override
    public void delete(Bell bell) {
        bellList.remove(bell);
    }

    @Override
    public List<Bell> getAll() {
        return bellList;
    }

    @Override
    public Bell getById(Long id) {
        for (Bell bell : bellList) {
            if (bell.getId().equals(id))
                return bell;
        }
        return null;
    }
}
