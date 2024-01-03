package com.example.SpringDemo.controller;

import com.example.SpringDemo.service.MovieService;
import com.example.SpringDemo.models.MoviesDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin
@RequestMapping("/api/v1")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @CrossOrigin
    @GetMapping("/movies")
    public ResponseEntity<List<MoviesDocument>> allMovies(){
        return new ResponseEntity<List<MoviesDocument>>(movieService.getAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<Optional<MoviesDocument>> getMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<MoviesDocument>>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping("/getMovieByImdbId/{imdbId}")
    public ResponseEntity<Optional<MoviesDocument>> getMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<Optional<MoviesDocument>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
