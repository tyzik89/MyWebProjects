package com.work.vladimirs.notebookspringboot.repository;

import com.work.vladimirs.notebookspringboot.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Асбтрактный интерфейс для доступа к БД
 */
public interface NoteRepositoryDAO extends JpaRepository<Note, Long> {
    Note findNoteById(Long id);
    void deleteNoteById(Long id);
}
