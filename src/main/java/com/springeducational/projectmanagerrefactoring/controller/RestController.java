package com.springeducational.projectmanagerrefactoring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RestController {

    @GetMapping(value = "/test")
    public String welcome(Model model) {
        model.addAttribute("data", "Привет");
        return "test";
    }


}
