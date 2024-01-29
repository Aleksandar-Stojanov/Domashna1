package com.example.demo.controller;
import com.example.demo.model.Users_winery;
import com.example.demo.repository.Users_winery_Repository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {
    private final Users_winery_Repository usersWineryRepository;

    public LoginController(Users_winery_Repository usersWineryRepository) {
        this.usersWineryRepository = usersWineryRepository;
    }

    @GetMapping("/login")
    public String showLoginForm( HttpServletRequest request) {
        if(Optional.ofNullable(request.getSession().getAttribute("user")).isPresent()){
            return "redirect:/wine/home";}
        return "login";
    }
    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpServletRequest request,
                               Model model) {
        Users_winery user;
        user = usersWineryRepository.findByUsernameAndPassword(username,password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/wine/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}

