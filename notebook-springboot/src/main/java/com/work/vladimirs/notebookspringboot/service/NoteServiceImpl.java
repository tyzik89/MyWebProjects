package com.work.vladimirs.notebookspringboot.service;

import com.work.vladimirs.notebookspringboot.entity.Note;
import com.work.vladimirs.notebookspringboot.repository.NoteRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepositoryDAO repositoryDAO;

    @Autowired
    public void setRepositoryDAO(NoteRepositoryDAO repositoryDAO) {
        this.repositoryDAO = repositoryDAO;
    }

    @Override
    public Note getNoteById(Long id) {
        return repositoryDAO.findNoteById(id);
    }

    @Override
    public void saveNote(Note note) {
        repositoryDAO.save(note);
    }

    @Override
    public void updateNote(Long id, String message, boolean done) {
        Note updated = repositoryDAO.findNoteById(id);
        updated.setDone(done);
        updated.setMessage(message);
        repositoryDAO.save(updated);
    }

    @Override
    public void deleteNote(Long id) {
        repositoryDAO.deleteNoteById(id);
    }

    @Override
    public List<Note> findAll() {
        return repositoryDAO.findAll();
    }
}
