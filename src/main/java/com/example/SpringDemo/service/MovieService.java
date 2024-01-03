package com.example.SpringDemo.service;

import com.example.SpringDemo.Repository.MovieRepository;
import com.example.SpringDemo.models.MoviesDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //we write the database access methods here.
    @Autowired
    private MovieRepository movieRepository;
    public List<MoviesDocument> getAllMovies(){
        return movieRepository.findAll();
    }
    public Optional<MoviesDocument> getMovieById(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<MoviesDocument> getMovieByImdbId(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
}
