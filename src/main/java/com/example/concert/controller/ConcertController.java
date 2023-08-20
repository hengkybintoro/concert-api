package com.example.concert.controller;

import com.example.concert.model.Concert;
import com.example.concert.service.ConcertService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/concerts")
@Tag(name = "Concert Controller", description = "Concert controller will handle related things to concert.")
public class ConcertController {
    @Autowired
    private ConcertService concertService;

    @GetMapping("/available")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Concert.class)))
    public List<Concert> searchAvailableConcerts(@RequestParam LocalDateTime startTime) {
        return concertService.searchAvailableConcerts(startTime);
    }
}
