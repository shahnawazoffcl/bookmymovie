package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TicketResponseDTO {
    private Long id;
    private String movieName;
    private String theatreName;
    private String screenName;
    private Date showDate;
    private Date startTime;
    private Date endTime;
    private List<ShowSeatResponseDTO> showSeats;
    private double price;
    private String showSeatStatus;
    private String bookingStatus;
}
