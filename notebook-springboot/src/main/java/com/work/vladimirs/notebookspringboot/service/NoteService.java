package com.work.vladimirs.notebookspringboot.service;

import com.work.vladimirs.notebookspringboot.entity.Note;

import java.util.List;

public interface NoteService {
    Note getNoteById(Long id);
    void saveNote(Note note);
    void updateNote(Long id, String message, boolean done);
    void deleteNote(Long id);
    List<Note> findAll();
}
