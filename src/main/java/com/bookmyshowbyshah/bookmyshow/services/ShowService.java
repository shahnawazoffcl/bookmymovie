package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Show;

import java.util.List;

public interface ShowService {

    public Show getShow(Long showId);
    public List<Show> getAllShows();

}
