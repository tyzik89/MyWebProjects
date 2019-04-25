package com.amondin.model.repositories.impl;

import com.amondin.model.entities.Bell;
import com.amondin.model.repositories.BellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
@Qualifier("jdbc_repository")
public class BellRepositoryJDBCImpl implements BellRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private Bell mapRowToBell(ResultSet rs, int rowNum) throws SQLException {
        return new Bell(
                rs.getLong("id"),
                rs.getObject("creation_date", LocalDateTime.class)
        );
    }

    @Override
    public Iterable<Bell> getAll() {
        return jdbc.query("select id, creation_date from Bells", this::mapRowToBell);
    }

    @Override
    public Bell getById(Long id) {
        return jdbc.queryForObject("select id, creation_date from Bells where id = ?", this::mapRowToBell, id);
    }

    @Override
    public Bell save(Bell bell) {
        jdbc.update(
                "insert into Bells (id, creation_date) values (?, ?)",
                bell.getId(),
                bell.getCreationDate()
        );
        return bell;
    }

    @Override
    public boolean delete(Long id) {
        return (jdbc.update(
                "delete from Bells where id = ?",
                id) == 1);
    }
}
