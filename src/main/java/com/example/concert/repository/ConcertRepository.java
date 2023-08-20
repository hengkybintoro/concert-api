package com.example.concert.repository;

import com.example.concert.model.Concert;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
    
    @Query("SELECT c FROM Concert c WHERE c.startTime > :startTime")
    List<Concert> findConcertsAfterStartTime(LocalDateTime startTime);
}
