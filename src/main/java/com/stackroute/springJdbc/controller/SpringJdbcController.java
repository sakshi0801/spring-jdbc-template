package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository jdbcRepository;

    public SpringJdbcController() {
    }

    public ResponseEntity<String> insertMovie(){
        Movie movie=new Movie(1,"End Game",2019,5);
        jdbcRepository.addMovie(movie);
        return new ResponseEntity("Movie added "+movie.getMovieName(), HttpStatus.OK);
    }

    public ResponseEntity<?> getAllMovies(){
        List<Movie> movies=jdbcRepository.getAllMovies();
        return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
    }

    public ResponseEntity<String> getMovieById(){
        Movie movie=jdbcRepository.getMovieById(1);
        return new ResponseEntity("Movie is "+movie.getMovieName(),HttpStatus.OK);
    }

    public ResponseEntity<String> deleteMovieById(){
        jdbcRepository.deleteMovieById(1);
        return new ResponseEntity("Movie is deleted",HttpStatus.OK);
    }

    public ResponseEntity<String> updateMovieRatings(){
        jdbcRepository.updateMovieRatings(7.5f,"End Game");
        return new ResponseEntity("Ratings updated",HttpStatus.OK);
    }
}
