package com.pranay.controller;

import com.pranay.model.User;
import com.pranay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    private User loggedInUser;

    @GetMapping("/")
    public String home(Model model) {
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", loggedInUser);
        return "home";
    }
    
    @GetMapping("/home")
    public String Main() {
        return "home";
    }

    @GetMapping("/services")
    public String service() {
        return "service";
    }

    @GetMapping("/projects")
    public String project() {
        return "projects";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
