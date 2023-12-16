package com.bookmyshowbyshah.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection //Mapping table for screen to features
    private List<Feature> features;
    @ManyToOne
    private Theatre theatre;
}
