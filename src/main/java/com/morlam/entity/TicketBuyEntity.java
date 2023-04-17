package com.morlam.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
@Entity
@Table(name = "tb_ticket_buy")
@Data
public class TicketBuyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buy_id")
	private Integer buyId;
	
	@Column(name = "buy_status")
	private Integer buyStatus;
	
	@Column(name = "buy_date")
	private Date buyDate;
	
    
}
