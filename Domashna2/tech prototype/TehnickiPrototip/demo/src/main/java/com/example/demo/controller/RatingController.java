//package com.example.demo.controller;
//
//import com.example.demo.model.winery;
//import com.example.demo.services.WineryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import java.util.Collection;
//
//@Controller
//@RequestMapping("/rating")
//public class RatingController {
//    @Autowired
//    private WineryService wineryService;
//
//    @PostMapping("/submit")
//    @ResponseBody
//    public ResponseEntity<String> submitRating(@RequestParam Long wineryId, @RequestParam Float rating) {
//        try {
//            // Retrieve the winery from the database
//            winery existingWinery = wineryService.findById(wineryId);
//
//            if (existingWinery != null) {
//                // Add the new rating to the existing ratings
//                Collection<Float> ratings = existingWinery.getRatings();
//                ratings.add(rating);
//
//                // Calculate the average rating
//                Float averageRating = calculateAverageRating(ratings);
//
//                // Update the winery's average rating
//                existingWinery.setRating(averageRating);
//
//                // Save the updated winery to the database
//                wineryService.save(existingWinery);
//
//                return ResponseEntity.ok("Rating submitted successfully");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Winery not found");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting rating");
//        }
//    }
//
//    // Helper method to calculate the average rating
//    private Float calculateAverageRating(Collection<Float> ratings) {
//        if (!ratings.isEmpty()) {
//            float sum = 0.0f;
//            for (Float rating : ratings) {
//                sum += rating;
//            }
//            return sum / ratings.size();
//        } else {
//            return 0.0f; // or handle the case where there are no ratings
//        }
//    }
//}
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

@Controller
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private WineryService wineryService;

    @PostMapping("/submit")
    public String submitRating(@RequestParam Long wineryId, @RequestParam Float rating) {
        try {
            // Retrieve the winery from the database
            winery existingWinery = wineryService.findById(wineryId);

            if (existingWinery != null) {
                // Calculate the new average rating
                Float currentRating = existingWinery.getRating();
                Integer currentNumberOfRatings = existingWinery.getNumberOfRatings();

                Float newRating = (currentRating * currentNumberOfRatings + rating) / (currentNumberOfRatings + 1);

                // Update the winery's average rating and number of ratings
                existingWinery.setRating(newRating);
                existingWinery.setNumberOfRatings(currentNumberOfRatings + 1);

                // Save the updated winery to the database
                wineryService.save(existingWinery);

                return "redirect:/winery-details/" + wineryId; // Redirect to winery details page
            } else {
                return "error"; // Or any other error page you have
            }
        } catch (Exception e) {
            return "error"; // Or any other error page you have
        }
    }

}
