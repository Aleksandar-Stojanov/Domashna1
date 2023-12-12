package com.example.demo.controller;

import com.example.demo.services.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private WineryService wineryService;

    @PostMapping("/submit")
    @ResponseBody
    public ResponseEntity<String> submitRating(@RequestParam Long wineryId, @RequestParam Double rating) {
        // Implement the logic to update the rating in the database
        // You can use the WineryService to update the rating for the specified winery
        // Calculate the average rating and update the winery entity
        // Return a success message or handle errors appropriately
        return ResponseEntity.ok("Rating submitted successfully");
    }
}
