package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.ShowRepository;
import com.bookmyshowbyshah.bookmyshow.exceptions.ShowNotFoundException;
import com.bookmyshowbyshah.bookmyshow.models.Show;
import com.bookmyshowbyshah.bookmyshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show getShow(Long showId) {

        return this.showRepository.findById(showId).orElseThrow(() -> new ShowNotFoundException("Show not found"));
    }

    @Override
    public List<Show> getAllShows() {
        return this.showRepository.findAll();
    }
}
