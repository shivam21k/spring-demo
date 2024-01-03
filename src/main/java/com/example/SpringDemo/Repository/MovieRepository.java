package com.example.SpringDemo.Repository;

import com.example.SpringDemo.models.MoviesDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<MoviesDocument, ObjectId> {
    //we only need to define the below function, it will search for the document with imdbId provided.
    public Optional<MoviesDocument> findByImdbId(String imdbId);
}
