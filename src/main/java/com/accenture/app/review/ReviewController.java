package com.accenture.app.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @GetMapping("/reviews")
    public ResponseEntity<?> getAllReviews(@PathVariable Long companyId) {
        return service.getAllReviews(companyId).isEmpty() ?
                new ResponseEntity<>("No reviews found", HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(service.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews/add")
    public ResponseEntity<?> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        if (review != null) {
            service.createReview(companyId, review);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>("unable to add entry.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(service.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/update/{reviewId}")
    public ResponseEntity<?> updateReviewById(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean isReviewUpdated = service.updateReviewById(review, companyId, reviewId);
        return isReviewUpdated ? new ResponseEntity<>("update successfully", HttpStatus.OK) :
                new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<?> deleteById(@PathVariable Long reviewId,@PathVariable Long companyId) {
        return service.deleteReviewById(reviewId, companyId) ?
                new ResponseEntity<>("review with id " + reviewId + " deleted successfully", HttpStatus.OK) :
                new ResponseEntity<>("Unable to delete review", HttpStatus.BAD_REQUEST);
    }

}
