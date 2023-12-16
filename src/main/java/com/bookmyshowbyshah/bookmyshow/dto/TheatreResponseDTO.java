package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreResponseDTO {
    private Long id;
    private String name;
    private String region;

    public String toString() {
        return "name=" + this.getName() + ",\n region=" + this.getRegion();
    }
}
