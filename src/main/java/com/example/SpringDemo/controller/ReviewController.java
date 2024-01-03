package com.example.SpringDemo.controller;

import com.example.SpringDemo.models.ReviewsDocument;
import com.example.SpringDemo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping("/addReview")
    public ResponseEntity<ReviewsDocument> addReview(@RequestBody Map<String, String> request){
        return new ResponseEntity<>(reviewService.createReview(request.get("reviewBody"), request.get("imdbId")),HttpStatus.CREATED);
    }
}
