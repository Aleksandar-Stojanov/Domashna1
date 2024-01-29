package com.example.demo.controller;
import com.example.demo.model.winery;
import com.example.demo.services.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rating")
public class RatingController {

    private final WineryService wineryService;

    public RatingController(WineryService wineryService) {
        this.wineryService = wineryService;
    }


    @PostMapping("/submit/{id}")
    public String submitRating(@PathVariable Long id, @RequestParam Integer rating) {
        try {

            winery existingWinery = wineryService.findById(id);

            if (existingWinery != null) {
                Float currentRating = existingWinery.getRating();
                Integer currentNumberOfRatings = Integer.parseInt(String.valueOf(existingWinery.getNumberOfRatings()));

                Float newRating = (currentRating * currentNumberOfRatings + rating) / (currentNumberOfRatings + 1);

                existingWinery.setRating(newRating);
                existingWinery.setNumberOfRatings(currentNumberOfRatings + 1);

                wineryService.save(existingWinery);

                return "redirect:/wine/winery-details/" + id;
            } else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

}
