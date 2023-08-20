package com.example.concert.controller;

import com.example.concert.model.Ticket;
import com.example.concert.model.TicketRequest;
import com.example.concert.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TicketControllerTest {

    @InjectMocks
    private TicketController ticketController;

    @Mock
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBookTicket() {
        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setConcertId(1L);
        ticket.setAttendeeName("John Doe");

        when(ticketService.bookTicket(ticket.getConcertId(), ticket.getAttendeeName())).thenReturn(ticket);

        TicketRequest ticketRequest = new TicketRequest();
        ticketRequest.setConcertId(1L);
        ticketRequest.setAttendeeName("John Doe");

        Ticket response = ticketController.bookTicket(ticketRequest);

        assertEquals(ticket.getConcertId(), response.getConcertId());
        assertEquals(ticket.getAttendeeName(), response.getAttendeeName());
    }
}
