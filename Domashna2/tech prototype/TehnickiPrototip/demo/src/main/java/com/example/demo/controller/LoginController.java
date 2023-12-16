package com.example.demo.controller;
import com.example.demo.model.Users_winery;
import com.example.demo.repository.Users_winery_Repository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {
    //ovoj del za proverka na username pass ponatamu bi go sredil vo service del!
    private final Users_winery_Repository usersWineryRepository;

    public LoginController(Users_winery_Repository usersWineryRepository) {
        this.usersWineryRepository = usersWineryRepository;
    }

    // Display the login form
    @GetMapping("/login")
    public String showLoginForm( HttpServletRequest request) {
        if(Optional.ofNullable(request.getSession().getAttribute("user")).isPresent())
            return "redirect:/wine/home";
        return "login";
    }
    // Process the login form submission
    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpServletRequest request,
                               Model model) {
        Users_winery user = null;
        user = usersWineryRepository.findByUsernameAndPassword(username,password);
        if (user !=null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/wine/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}

