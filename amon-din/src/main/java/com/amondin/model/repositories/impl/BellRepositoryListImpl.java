package com.amondin.model.repositories.impl;

import com.amondin.model.entities.Bell;
import com.amondin.model.repositories.BellRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("list_repository")
public class BellRepositoryListImpl implements BellRepository {

    private List<Bell> bellList = new ArrayList<Bell>();

    @Override
    public Bell save(Bell bell) {
        bellList.add(bell);
        return bell;
    }

    @Override
    public boolean delete(Long id) {
        for (Bell bell : bellList) {
            if (bell.getId() == id) {
                bellList.remove(bell);
                return true;
            }
        }
        return false;
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
