package com.bookmyshowbyshah.bookmyshow.Controllers;

import com.bookmyshowbyshah.bookmyshow.Controllers.utils.MovieControllerUtils;
import com.bookmyshowbyshah.bookmyshow.dto.MovieResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.Movie;
import com.bookmyshowbyshah.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping()
    public ResponseEntity<MovieResponseDTO> addNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(MovieControllerUtils.convertMovieToMovieResponseDTO(this.movieService.addMovie(movie)));
    }


    @GetMapping(path = "/all")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {

        List<MovieResponseDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : this.movieService.getAllMovies()) {
            moviesDTO.add(MovieControllerUtils.convertMovieToMovieResponseDTO(movie));
        }
        return ResponseEntity.ok(moviesDTO);
    }

    @GetMapping(path = "/{movieId}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(MovieControllerUtils.convertMovieToMovieResponseDTO(this.movieService.getMovie(movieId)));
    }


}
