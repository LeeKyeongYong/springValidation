package com.example.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = {"/", "new"}, method = RequestMethod.GET)
    public String enroll(Model model) {
       // User user = new User();
       // model.addAttribute("user", user);
        return "index";
    }
}
