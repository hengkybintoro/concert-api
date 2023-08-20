package com.example.concert.service;

import com.example.concert.exception.ConcertNotFoundException;
import com.example.concert.model.Concert;
import com.example.concert.model.Ticket;
import com.example.concert.repository.ConcertRepository;
import com.example.concert.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TicketServiceTest {

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private ConcertRepository concertRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBookTicket_Success() {
        Long concertId = 1L;
        String attendeeName = "John Doe";

        Concert concert = new Concert();
        concert.setId(concertId);

        when(concertRepository.findById(concertId)).thenReturn(Optional.of(concert));

        Ticket savedTicket = new Ticket();
        savedTicket.setId(1L);
        savedTicket.setConcertId(concertId);
        savedTicket.setAttendeeName(attendeeName);

        when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);

        Ticket bookedTicket = ticketService.bookTicket(concertId, attendeeName);

        assertEquals(savedTicket, bookedTicket);

        verify(concertRepository, times(1)).findById(concertId);
        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }

    @Test
    public void testBookTicket_ConcertNotFound() {
        Long concertId = 1L;
        String attendeeName = "John Doe";

        when(concertRepository.findById(concertId)).thenReturn(Optional.empty());

        assertThrows(ConcertNotFoundException.class, () -> {
            ticketService.bookTicket(concertId, attendeeName);
        });

        verify(concertRepository, times(1)).findById(concertId);
        verify(ticketRepository, never()).save(any(Ticket.class));
    }
}
