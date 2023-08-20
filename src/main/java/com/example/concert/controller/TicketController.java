package com.example.concert.controller;

import com.example.concert.model.Ticket;
import com.example.concert.model.TicketRequest;
import com.example.concert.service.TicketService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Ticket Controller", description = "Ticket controller will handle related things to ticket.")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class)))
    public Ticket bookTicket(@RequestBody TicketRequest ticketRequest) {
        return ticketService.bookTicket(ticketRequest.getConcertId(), ticketRequest.getAttendeeName());
    }
}
