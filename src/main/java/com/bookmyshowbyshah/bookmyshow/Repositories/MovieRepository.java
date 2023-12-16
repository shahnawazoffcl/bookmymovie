package com.bookmyshowbyshah.bookmyshow.Repositories;

import com.bookmyshowbyshah.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
