package com.bookmyshowbyshah.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat  extends BaseModel{
    private int row;
    private int column;
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;


}
