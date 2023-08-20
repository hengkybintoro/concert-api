package com.example.concert.service;

import com.example.concert.model.Ticket;

public interface TicketService {
    Ticket bookTicket(Long concertId, String attendeeName);
}
