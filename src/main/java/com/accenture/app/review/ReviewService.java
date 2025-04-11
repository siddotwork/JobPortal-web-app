package com.accenture.app.review;

import java.util.List;

public interface ReviewService {
    List<Review>getAllReviews(Long companyId);
    Review createReview(Long companyId,Review review);
    Review getReviewById(Long companyId,Long reviewId);
    boolean updateReviewById(Review review, Long companyId, Long reviewId);
    boolean deleteReviewById(Long companyId, Long reviewId);
}
