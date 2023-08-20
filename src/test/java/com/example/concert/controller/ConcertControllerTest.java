package com.example.concert.controller;

import com.example.concert.model.Concert;
import com.example.concert.service.ConcertService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConcertControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ConcertController concertController;

    @MockBean
    private ConcertService concertService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(concertController).build();
    }

    @Test
    public void testSearchAvailableConcerts() throws Exception {
        LocalDateTime startTime = LocalDateTime.now();

        Concert concert = new Concert();
        concert.setId(1);
        concert.setName("Test Concert");
        concert.setStartTime(startTime);
        concert.setVenue("Test Venue");

        List<Concert> availableConcerts = Arrays.asList(concert);

        when(concertService.searchAvailableConcerts(startTime)).thenReturn(availableConcerts);

        mockMvc.perform(get("/api/concerts/available")
                .param("startTime", startTime.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Concert"))
                .andExpect(jsonPath("$[0].venue").value("Test Venue"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testSearchAvailableConcerts_negative() throws Exception {
        LocalDateTime startTime = LocalDateTime.now();

        Concert concert = new Concert();
        concert.setId(1);
        concert.setName("Test Concert");
        concert.setStartTime(startTime);
        concert.setVenue("Test Venue");

        // Simulate empty list of available concerts
        List<Concert> availableConcerts = Collections.emptyList();

        when(concertService.searchAvailableConcerts(startTime)).thenReturn(availableConcerts);

        mockMvc.perform(get("/api/concerts/available")
                .param("startTime", startTime.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty())
                .andDo(MockMvcResultHandlers.print());
    }
}
