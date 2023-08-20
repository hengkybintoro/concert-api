package com.example.concert.service;

import com.example.concert.exception.ConcertNotFoundException;
import com.example.concert.model.Concert;
import com.example.concert.model.Ticket;
import com.example.concert.repository.ConcertRepository;
import com.example.concert.repository.TicketRepository;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ConcertRepository concertRepository;

    private Lock bookingLock = new ReentrantLock();

    @Override
    public Ticket bookTicket(Long concertId, String attendeeName) {
        Concert concert = concertRepository.findById(concertId)
            .orElseThrow(() -> new ConcertNotFoundException("Concert not found"));

        bookingLock.lock();

        try {
            Ticket ticket = new Ticket();
            ticket.setConcertId(concertId);
            ticket.setAttendeeName(attendeeName);

            return ticketRepository.save(ticket);  
        } finally {
            bookingLock.unlock();
        }
    }
}
