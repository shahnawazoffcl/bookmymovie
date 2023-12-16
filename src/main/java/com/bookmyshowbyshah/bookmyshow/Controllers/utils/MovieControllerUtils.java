package com.bookmyshowbyshah.bookmyshow.Controllers.utils;

import com.bookmyshowbyshah.bookmyshow.dto.MovieResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.Movie;

import java.util.List;

public class MovieControllerUtils {
    public static MovieResponseDTO convertMovieToMovieResponseDTO(Movie movie){
        MovieResponseDTO movieResponseDTO = new MovieResponseDTO();
        movieResponseDTO.setId(movie.getId());
        movieResponseDTO.setName(movie.getName());
        movieResponseDTO.setDescription(movie.getDescription());
        movieResponseDTO.setLanguage(movie.getLanguage());
        movieResponseDTO.setReleaseDate(movie.getReleaseDate());
        movieResponseDTO.setDurationInMinutes(movie.getDurationInMinutes());
        movieResponseDTO.setPosterUrl(movie.getPosterUrl());
        return movieResponseDTO;
    }
}
