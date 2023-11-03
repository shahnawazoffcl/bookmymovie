package com.bookmyshowbyshah.Repositories;

import com.bookmyshowbyshah.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
