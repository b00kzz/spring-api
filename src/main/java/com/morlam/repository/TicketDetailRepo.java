package com.morlam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morlam.entity.TicketDetail;

@Repository
public interface TicketDetailRepo extends JpaRepository<TicketDetail, Integer> {
    
}
