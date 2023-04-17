package com.morlam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morlam.model.TicketBuyResModel;
import com.morlam.service.TicketBuyService;

@RestController
public class TicketBuyController {
    @Autowired
	TicketBuyService ticketBuyService;
	
	// ดึงข้อมูลของ table Role ขึ้นมาทั้งหมด
	@GetMapping("/buy")
	public List<TicketBuyResModel> getTicketAll(){
		return ticketBuyService.getTicketAll();
	}
	
	// ดึงข้อมูลของ table Role ขึ้นมาตาม RoleId
	@GetMapping("/buy/{buyId}")
	public TicketBuyResModel getTicketById(@PathVariable Integer buyId) {
		
		return ticketBuyService.getTicketById(buyId);
	}
	
	@PostMapping("/buy")
	public void saveTicketBuy(@RequestBody TicketBuyResModel request) {
		ticketBuyService.saveTicketBuy(request);
	}
	
	@PutMapping("/buy/{buyId}")
	public void updateRole(@RequestBody TicketBuyResModel request, @PathVariable Integer buyId) {
		ticketBuyService.updateTicket(request, buyId);
	}
	
	@DeleteMapping("/buy/{buyId}")
	public void deleteTicket(@PathVariable Integer buyId) {
		ticketBuyService.deleteTicket(buyId);
	}
	
}
