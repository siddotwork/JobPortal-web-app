package com.accenture.app.review;

import com.accenture.app.company.Company;
import com.accenture.app.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository repository;
    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = repository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review createReview(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);
        System.out.println(company.getName());

        if (company != null) {
            review.setCompany(company);
            repository.save(review);
            return review;
        }
        return null;

    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = repository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReviewById(Review review, Long companyId, Long reviewId) {
        Review retrivedReview = companyService.findCompanyById(companyId).getReviews().stream().filter(x -> repository.existsById(reviewId)).findFirst().get();
        if (retrivedReview!=null) {
            retrivedReview.setDescription(review.getDescription());
            retrivedReview.setRating(review.getRating());
            retrivedReview.setTitle(review.getTitle());
            repository.save(retrivedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        if (companyService.findCompanyById(companyId) != null && repository.existsById(reviewId)) {
            repository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}