package com.bookmyshowbyshah.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Theatre extends BaseModel{
    private String name;
    @ManyToOne
    private Region region;

}
