package com.springeducational.projectmanagerrefactoring.controller;

import com.springeducational.projectmanagerrefactoring.auth.UserService;
import com.springeducational.projectmanagerrefactoring.dto.UserDto;
import com.springeducational.projectmanagerrefactoring.entity.User;
import com.springeducational.projectmanagerrefactoring.utils.CheckAuth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(Model model) {

        if (CheckAuth.isUser()) {
            model.addAttribute("isUser", true);
        }


        if(CheckAuth.isAdmin()) {
            model.addAttribute("isAdmin", true);
        }
        return "main";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
