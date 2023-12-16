package com.bookmyshowbyshah.bookmyshow.Controllers.utils;

import com.bookmyshowbyshah.bookmyshow.dto.ShowSeatResponseDTO;
import com.bookmyshowbyshah.bookmyshow.dto.TicketResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.ShowSeat;
import com.bookmyshowbyshah.bookmyshow.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketControllerUtils {

    public static TicketResponseDTO convertTicketToTicketResponseDTO(Ticket ticket){
        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setId(ticket.getId());
        ticketResponseDTO.setMovieName(ticket.getShow().getMovie().getName());
        ticketResponseDTO.setTheatreName(ticket.getShow().getTheatre().getName());
        ticketResponseDTO.setScreenName(ticket.getShow().getScreen().getName());
        ticketResponseDTO.setShowDate(ticket.getShow().getShowDate());
        ticketResponseDTO.setStartTime(ticket.getShow().getStartTime());
        ticketResponseDTO.setEndTime(ticket.getShow().getEndTime());
        ticketResponseDTO.setShowSeats(convertShowSeatsToShowSeatResponseDTOs(ticket.getShowSeats()));
        return ticketResponseDTO;
    }

    public static List<ShowSeatResponseDTO> convertShowSeatsToShowSeatResponseDTOs(List<ShowSeat> showSeats){
        List<ShowSeatResponseDTO> showSeatResponseDTOs = new ArrayList<>();
        for (ShowSeat showSeat : showSeats) {
            ShowSeatResponseDTO showSeatResponseDTO = new ShowSeatResponseDTO();
            showSeatResponseDTO.setId(showSeat.getId());
            showSeatResponseDTO.setShowSeatStatus(showSeat.getShowSeatStatus());
            showSeatResponseDTO.setPrice(showSeat.getPrice());
            showSeatResponseDTO.setShowDate(showSeat.getShow().getShowDate());
            showSeatResponseDTO.setSeatType(showSeat.getSeat().getSeatType().toString());
            showSeatResponseDTOs.add(showSeatResponseDTO);
        }
        return showSeatResponseDTOs;
    }
}
