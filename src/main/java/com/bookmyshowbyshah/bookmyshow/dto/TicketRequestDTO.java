package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketRequestDTO {

    private Long userId;
    private Long showId;
    private List<Long> seatIds;
}
