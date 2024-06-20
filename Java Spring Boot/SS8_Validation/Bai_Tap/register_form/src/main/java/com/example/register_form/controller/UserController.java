package com.example.register_form.controller;

import com.example.register_form.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String showIndex(Model model) {
        model.addAttribute("user", new User());
        return "/user/index";
    }

    @PostMapping("/sign")
    public String showResult(@Validated User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/user/index";
        }
        model.addAttribute("user", user);
        return "/user/result";
    }
}