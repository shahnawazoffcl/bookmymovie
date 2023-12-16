package com.bookmyshowbyshah.bookmyshow.dto;

import com.bookmyshowbyshah.bookmyshow.models.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ShowSeatResponseDTO {
    private Long id;
    private Date showDate;
    private String seatType;
    private double price;
    private ShowSeatStatus showSeatStatus;

    public String toString() {
        return "Show Date=" + this.getShowDate() + ", Seat Type=" + this.getSeatType() + ", price=" + this.getPrice();
    }
}
