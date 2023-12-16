package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Ticket;
import com.bookmyshowbyshah.bookmyshow.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId);
    Ticket cancelTicket(Long ticketId);
    Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId);
    List<Ticket> getAllTicketsByUserId(Long userId);
}
