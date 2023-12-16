package com.bookmyshowbyshah.bookmyshow.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "shows")
public class Show extends BaseModel{
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date showDate;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Kolkata")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Kolkata")
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Screen screen;
}
