package com.example.SpringDemo.Repository;

import com.example.SpringDemo.models.ReviewsDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewsDocument, ObjectId> {
}
