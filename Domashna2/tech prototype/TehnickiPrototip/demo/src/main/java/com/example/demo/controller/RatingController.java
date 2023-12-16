package com.example.demo.controller;

import com.example.demo.model.winery;
import com.example.demo.services.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private WineryService wineryService;

    @PostMapping("/submit")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> submitRating(@RequestParam Long wineryId, @RequestParam Float rating) {
        try {
            Float updatedRating = wineryService.submitRating(wineryId, rating);

            if (updatedRating != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Rating submitted successfully");
                response.put("rating", updatedRating);

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "Winery not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Error submitting rating"));
        }
    }

}
