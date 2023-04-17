package com.morlam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ticket_detail")
@Data
public class TicketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;
    
    @Column(name = "ticket_name")
    private String ticketName;
    
    @Column(name = "ticket_type")
    private Integer ticketType;
    
    @Column(name = "ticket_price")
    private Integer ticketPrice;
    
    @Column(name = "ticket_desc")
    private String ticketDesc;

}
