package com.bookmyshowbyshah.bookmyshow.Controllers;


import com.bookmyshowbyshah.bookmyshow.Controllers.utils.ShowControllerUtils;
import com.bookmyshowbyshah.bookmyshow.dto.ShowResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.Show;
import com.bookmyshowbyshah.bookmyshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping(path = "/{showId}")
    public ResponseEntity<ShowResponseDTO> getShow(@PathVariable Long showId){
        Show show = showService.getShow(showId);

        if(ShowControllerUtils.validateShow(show)){
        return ResponseEntity.ok(ShowControllerUtils.convertShowToShowResponseDTO(show));}
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ShowResponseDTO>> getAllShows(){
        List<ShowResponseDTO> responseDTO = new ArrayList<>();
        for (Show show : showService.getAllShows()) {
            responseDTO.add(ShowControllerUtils.convertShowToShowResponseDTO(show));
        }
        return ResponseEntity.ok(responseDTO);
    }

}
