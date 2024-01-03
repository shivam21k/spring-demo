package com.example.SpringDemo.service;

import com.example.SpringDemo.models.MoviesDocument;
import com.example.SpringDemo.Repository.ReviewRepository;
import com.example.SpringDemo.models.ReviewsDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate; //suitable for heavy lifting that repository can't do.
    public ReviewsDocument createReview(String reviewBody, String imdbId){
        ReviewsDocument review = reviewRepository.insert(new ReviewsDocument(reviewBody));
        try {
            mongoTemplate.update(MoviesDocument.class)
                    .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("reviewIdsList").value(review))
                    .first();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return review;
    }
}
