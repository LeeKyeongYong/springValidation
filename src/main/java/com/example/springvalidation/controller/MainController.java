package com.example.springvalidation.controller;

import com.example.springvalidation.model.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = {"/", "new"}, method = RequestMethod.GET)
    public String enroll(Model model) {
        UserDTO user=new UserDTO();
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value="result",method=RequestMethod.POST)
    public String result(@Valid UserDTO user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAllAttributes(bindingResult.getModel());
            return "index";
        } else {
            model.addAttribute("user",user);
            return "result";
        }
    }
}
