package com.bookmyshowbyshah.bookmyshow.Repositories;

import com.bookmyshowbyshah.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public List<Ticket> findAllByUserId(Long userId);
}
