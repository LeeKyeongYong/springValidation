package com.example.springvalidation.controller;

import com.example.springvalidation.model.UserDTO;
import com.example.springvalidation.model.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String enroll(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "index";
    }

        @PostMapping("/result")
        public String result(@ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {
           userValidator.validate(user, bindingResult);
            if (bindingResult.hasErrors()) {
                model.addAllAttributes(bindingResult.getModel());
                return "index";
            } else {
                model.addAttribute("user", user);
                return "result";
            }
        }
    }