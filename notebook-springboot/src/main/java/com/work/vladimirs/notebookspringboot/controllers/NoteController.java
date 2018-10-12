package com.work.vladimirs.notebookspringboot.controllers;

import com.work.vladimirs.notebookspringboot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {
    private NoteService service;

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        return "index";
    }
}
