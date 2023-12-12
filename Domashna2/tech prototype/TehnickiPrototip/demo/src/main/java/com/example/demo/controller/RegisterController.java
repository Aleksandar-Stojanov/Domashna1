package com.example.demo.controller;

import com.example.demo.model.Users_winery;
import com.example.demo.model.exceptions.PasswordsDoNotMatchException;
import com.example.demo.model.exceptions.InvalidArgumentsException;
import com.example.demo.model.exceptions.UsernameExistsException;
import com.example.demo.repository.Users_winery_Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {
    //bi go dodal vo poseben servis
    private final Users_winery_Repository usersWineryRepository;

    public RegisterController(Users_winery_Repository usersWineryRepository) {
        this.usersWineryRepository = usersWineryRepository;
    }

    @GetMapping
    public String getRegisterPage(Model model) {
        return "register";
    }

    @PostMapping
    public String registerUser(@RequestParam String username,
                               @RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String password,
                               @RequestParam String repeatPassword,
                               @RequestParam String dateOfBirth,
                               @RequestParam String email,
                               Model model) {
        try {
            LocalDate birthDate = LocalDate.parse(dateOfBirth);
            if (username.isEmpty() || username.equals("")||
                    !email.contains("@") || !email.contains(".com") ||
                    email.isEmpty() || email.equals("") ||
                    username.isEmpty() || username.equals("") ||
                    password.isEmpty() || password.equals("") ||
                    birthDate==null || birthDate.equals("")){
                throw new InvalidArgumentsException();
            }


            if (Optional.ofNullable(usersWineryRepository.findByUsername(username)).isPresent()) {
                throw new UsernameExistsException();
            }



            if (password.equals(repeatPassword)) {
                usersWineryRepository.saveuser(username,name, surname, password, birthDate, email);
            }else {
                throw new PasswordsDoNotMatchException();
            }


            Users_winery user = usersWineryRepository.findByUsername(username);
            model.addAttribute("user", user);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException | UsernameExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
