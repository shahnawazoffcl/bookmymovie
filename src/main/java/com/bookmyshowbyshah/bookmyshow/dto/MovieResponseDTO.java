package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String language;
    private Date releaseDate;
    private int durationInMinutes;
    private String posterUrl;
}
