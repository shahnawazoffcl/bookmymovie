package com.bookmyshowbyshah.bookmyshow.Controllers;


import com.bookmyshowbyshah.bookmyshow.Controllers.utils.TicketControllerUtils;
import com.bookmyshowbyshah.bookmyshow.dto.TicketRequestDTO;
import com.bookmyshowbyshah.bookmyshow.dto.TicketResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.Ticket;
import com.bookmyshowbyshah.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/book")
    public ResponseEntity<TicketResponseDTO> bookTicket(@RequestBody TicketRequestDTO ticketRequestDTO){
        TicketResponseDTO ticketResponseDTO;
        Ticket ticket;
        try{
            ticket = ticketService.bookTicket(ticketRequestDTO.getUserId(),ticketRequestDTO.getSeatIds(),ticketRequestDTO.getShowId());
            ticketResponseDTO = TicketControllerUtils.convertTicketToTicketResponseDTO(ticket);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticketResponseDTO);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<Iterable<TicketResponseDTO>> getAllTickets(@PathVariable Long userId){
        List<TicketResponseDTO> ticketResponseDTOs = new ArrayList<>();
        try{
            for (Ticket ticket:ticketService.getAllTicketsByUserId(userId)) {
                ticketResponseDTOs.add(TicketControllerUtils.convertTicketToTicketResponseDTO(ticket));
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticketResponseDTOs);
    }


}
