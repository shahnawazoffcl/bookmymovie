package com.bookmyshowbyshah.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat  extends BaseModel{
    private int rowNo;
    private int columnNo;
    private String seatNumber;
    private SeatType seatType;
}
