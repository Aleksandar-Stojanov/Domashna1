package com.example.demo.controller;
import com.example.demo.repository.Users_winery_Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //ovoj del za proverka na username pass ponatamu bi go sredil vo service del!
    private final Users_winery_Repository usersWineryRepository;

    public LoginController(Users_winery_Repository usersWineryRepository) {
        this.usersWineryRepository = usersWineryRepository;
    }

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
        if (usersWineryRepository.findByUsernameAndPassword(username,password)!=null) {
            return "redirect:/wine/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}

