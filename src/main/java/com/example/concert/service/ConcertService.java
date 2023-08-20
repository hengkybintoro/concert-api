package com.example.concert.service;

import com.example.concert.model.Concert;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertService {
    List<Concert> searchAvailableConcerts(LocalDateTime startTime);
}
