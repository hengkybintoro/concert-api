package com.example.concert.service;

import com.example.concert.model.Concert;
import com.example.concert.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConcertServiceImpl implements ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    @Override
    public List<Concert> searchAvailableConcerts(LocalDateTime startTime) {
        // Implement your logic to retrieve available concerts
        // You can use the concertRepository to fetch concerts
        return concertRepository.findConcertsAfterStartTime(startTime);
    }
}
