package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.MovieRepository;
import com.bookmyshowbyshah.bookmyshow.models.Movie;
import com.bookmyshowbyshah.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        movie.setCreatedAt(new Date());
        movie.setUpdatedAt(new Date());
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).get();
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
        return movies;
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
