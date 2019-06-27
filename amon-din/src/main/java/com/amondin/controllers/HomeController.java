package com.amondin.controllers;

import com.amondin.models.entities.Bell;
import com.amondin.models.services.BellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BellService bellService;

    @GetMapping
    public String getHome() {
        return "home";
    }

    // ДЛЯ ТЕСТА - ОТОБРАЖЕНИЯ НА СТРАНИЧКЕ
    @GetMapping(value = "/bells")
    public String getListBells(Model model) {
        Iterable<Bell> bellList = bellService.getAll();
        LOGGER.debug("bellList {}", bellList);
        model.addAttribute("bellList", bellList);
        return "bells";
    }
}
