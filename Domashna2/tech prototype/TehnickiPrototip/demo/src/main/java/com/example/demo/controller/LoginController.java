package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Display the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    // Process the login form submission
    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        if (username.equals("admin") && password.equals("password")) {
            return "redirect:/wine/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}

