package com.pranay.controller;


import com.pranay.model.User;
import com.pranay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private User loggedInUser;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(String username, String password) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            return "home";
        }
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}
