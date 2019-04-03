package com.amondin.controller;

import com.amondin.model.services.BellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private BellService bellService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    /* ДЛЯ ТЕСТА - ОТОБРАЖЕНИЯ НА СТРАНИЧКЕ
    @RequestMapping(value = "bells", method = RequestMethod.GET)
    public String getListBells(Model model) {
        List<Bell> bellList = bellService.getAll();
        model.addAttribute("bellList", bellList);
        return "bells";
    }*/
}
