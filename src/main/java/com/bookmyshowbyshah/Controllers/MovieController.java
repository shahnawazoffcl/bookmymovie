package com.bookmyshowbyshah.Controllers;

import com.bookmyshowbyshah.models.Movie;
import com.bookmyshowbyshah.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @PostMapping(path = "/add")
    public String addNewMovie(@RequestParam String name, @RequestParam String desc){
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(desc);
        movieRepository.save(movie);
        return "Saved";
    }

    @GetMapping(path = "/getAll")
    public Iterable<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

}
