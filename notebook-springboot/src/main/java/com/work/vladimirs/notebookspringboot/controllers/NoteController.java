package com.work.vladimirs.notebookspringboot.controllers;

import com.work.vladimirs.notebookspringboot.entity.Note;
import com.work.vladimirs.notebookspringboot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class NoteController {
    private NoteService service;

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String list(Model model) {
        List<Note> notebook = service.findAll();
        //model.addAttribute("notes", notebook);
        model.addAttribute("notes", "My fucking note");
        return "index";
    }
}
