package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Movie;

import java.util.List;

public interface MovieService {

    public Movie addMovie(Movie movie);
    public Movie updateMovie(Movie movie);
    public Movie getMovie(Long movieId);
    public List<Movie> getAllMovies();
    public void deleteMovie(Long movieId);

}
