package com.morlam.repository;

import org.springframework.stereotype.Repository;

import com.morlam.entity.TicketBuyEntity;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TicketBuyRepository extends JpaRepository<TicketBuyEntity, Integer> {
    
}
