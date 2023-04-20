package com.example.springvalidation.controller;

import com.example.springvalidation.model.UserDTO;
import com.example.springvalidation.model.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new UserValidator());
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String enroll(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "result", method = RequestMethod.POST)
        public String result(@ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {
        //public String result(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {
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


    /*

    Controller에서 유효성 검사가 필요한 DTO 객체를
    @Valid 어노테이션으로 주석 처리합니다.
    Controller 클래스 상단에 @InitBinder 어노테이션을 추가하고, WebDataBinder를 초기화합니다.
    WebDataBinder에 유효성 검사기 (Validator)를 등록합니다.
    이를 통해 모든 바인딩 대상 객체에 대해 유효성 검사가 수행됩니다.

    @Valid 어노테이션은 UserDTO 객체의 유효성 검사를 요청합니다.
    initBinder() 메서드는 WebDataBinder 객체를 초기화하고, UserValidator를 등록합니다.
    그리고 addUser() 메서드에서는 @ModelAttribute 어노테이션을 사용하여, 사용자가 제출한 폼 데이터를 UserDTO 객체에 매핑합니다.
    BindingResult 객체는 유효성 검사 결과를 저장합니다.
    hasErrors() 메서드를 사용하여 유효성 검사에 실패한 경우,
    에러 메시지를 모델에 추가하고 사용자에게 오류가 발생했음을 알리는 뷰를 반환합니다.
    유효성 검사에 성공한 경우 UserService를 사용하여 UserDTO 객체를 저장하고 사용자 목록 페이지로 리디렉션합니다.

     */