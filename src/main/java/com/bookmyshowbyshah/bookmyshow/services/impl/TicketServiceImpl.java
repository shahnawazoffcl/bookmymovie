package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.ShowRepository;
import com.bookmyshowbyshah.bookmyshow.Repositories.ShowSeatRepository;
import com.bookmyshowbyshah.bookmyshow.Repositories.TicketRepository;
import com.bookmyshowbyshah.bookmyshow.Repositories.UserRepository;
import com.bookmyshowbyshah.bookmyshow.exceptions.PaymentFailedException;
import com.bookmyshowbyshah.bookmyshow.exceptions.ShowSeatsNotAvailableException;
import com.bookmyshowbyshah.bookmyshow.exceptions.TicketNotFoundException;
import com.bookmyshowbyshah.bookmyshow.exceptions.UserNotFountException;
import com.bookmyshowbyshah.bookmyshow.models.*;
import com.bookmyshowbyshah.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ShowSeatRepository seatRepository, UserRepository userRepository, ShowRepository showRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = seatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        Show show = showRepository.findById(showId).get();

        for (Long showSeatId:showSeatIds){
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
                showSeatRepository.save(showSeat);
            }
            else{
                throw new ShowSeatsNotAvailableException("Show Seats Not Available.");
            }
        }
        Boolean paymentStatus = checkPaymentStatus();
        List<ShowSeat> showSeats = new ArrayList<>();
        double amount = 0;
        if(paymentStatus){
            for (Long showSeatId:showSeatIds){
                ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeat = showSeatRepository.save(showSeat);
                showSeats.add(showSeat);
                amount += showSeat.getPrice();
            }
        }
        else{
            for (Long showSeatId:showSeatIds){
                ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
                showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
                showSeatRepository.save(showSeat);
            }
            throw new PaymentFailedException("Payment Failed.");
        }
        return generateTicket(user, show, showSeats, amount);
    }
    private Ticket generateTicket(User user, Show show, List<ShowSeat> showSeats, double amount) {
        Ticket ticket = new Ticket();
        ticket.setAmount(amount);
        ticket.setBookingStatus(BookingStatus.BOOKED);
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setShowSeats(showSeats);
        return ticketRepository.save(ticket);
    }
    private Boolean checkPaymentStatus() {
        // TODO: 3rd party payment gateway integration.
        return true;
    }
    @Override
    public Ticket cancelTicket(Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if(optionalTicket.isEmpty()){
            throw new TicketNotFoundException("Ticket Not Found.");
        }

        Ticket ticket = optionalTicket.get();
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        for(ShowSeat seat: ticket.getShowSeats()){
            seat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(seat);
        }
        //Send a message to 3rd party with ref no for refund.
        return ticketRepository.save(ticket);
    }
    @Override
    public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if(optionalTicket.isEmpty()){
            throw new TicketNotFoundException("Ticket Not Found.");
        }
        Optional<User> optionalFromUser = userRepository.findById(fromUserId);
        Optional<User> optionalToUser = userRepository.findById(toUserId);

        if(optionalFromUser.isEmpty()||optionalToUser.isEmpty()){
            throw new UserNotFountException("Ticket can't be transferred. User Invalid.");
        }
        Ticket ticket = optionalTicket.get();
        User fromUser = optionalFromUser.get();
        List<Ticket> bookedTickets = fromUser.getTickets();
        bookedTickets.remove(ticket);
        userRepository.save(fromUser);

        User toUser = optionalToUser.get();
        toUser.getTickets().add(ticket);
        toUser = userRepository.save(toUser);

        ticket.setUser(toUser);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTicketsByUserId(Long userId) {
        if(this.userRepository.findById(userId).isEmpty()){
            throw new UserNotFountException("User Not Found.");
        }
        return ticketRepository.findAllByUserId(userId);
    }
}