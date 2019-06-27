package com.amondin.models.repositories.impl;

import com.amondin.models.entities.Bell;
import com.amondin.models.repositories.BellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
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

    /*//Сущность приходит уже с Id
    @Override
    public Bell save(Bell bell) {
        jdbc.update(
                "insert into Bells (id, creation_date) values (?, ?)",
                bell.getId(),
                bell.getCreationDate()
        );
        return bell;
    }*/

    //Сущность получает айди после вставки записи в БД. Сама БД генерирует id
    @Override
    public Bell save(Bell newBell) {
        long bellId = saveBellInfo(newBell);
        newBell.setId(bellId);
        return newBell;
    }

    private long saveBellInfo(Bell bell) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        "insert into Bells (creation_date) values (?)",
                        new String[] {"id"}
                );
                ps.setTimestamp(1, Timestamp.valueOf(bell.getCreationDate()));
                return ps;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(creator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean delete(Long id) {
        return (jdbc.update("delete from Bells where id = ?", id) == 1);
    }
}
