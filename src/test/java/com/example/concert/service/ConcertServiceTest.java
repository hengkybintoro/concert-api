package com.example.concert.service;

import com.example.concert.model.Concert;
import com.example.concert.repository.ConcertRepository;
import com.example.concert.service.ConcertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConcertServiceTest {

    @InjectMocks
    private ConcertServiceImpl concertService;

    @Mock
    private ConcertRepository concertRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchAvailableConcerts() {
        LocalDateTime startTime = LocalDateTime.now();

        Concert concert = new Concert();
        concert.setId(1);
        concert.setName("Test Concert");
        concert.setStartTime(startTime);
        concert.setVenue("Test Venue");

        List<Concert> availableConcerts = new ArrayList<>();
        availableConcerts.add(concert);

        when(concertRepository.findConcertsAfterStartTime(startTime)).thenReturn(availableConcerts);

        List<Concert> result = concertService.searchAvailableConcerts(startTime);

        assertEquals(availableConcerts, result);
    }
}
