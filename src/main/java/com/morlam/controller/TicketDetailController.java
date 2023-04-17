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

import com.morlam.model.TicketDetailReq;
import com.morlam.model.TicketDetailResp;
import com.morlam.service.TicketDetailScv;

@RestController
public class TicketDetailController {
    
	@Autowired
	TicketDetailScv detailService;
	
	// ดึงข้อมูลของ table Role ขึ้นมาทั้งหมด
	@GetMapping("/details")
	public List<TicketDetailResp> getTicketDetailAll(){
		return detailService.getTicketDetailAll();
	}
	
	// ดึงข้อมูลของ table Role ขึ้นมาตาม RoleId
	@GetMapping("/detail/{ticketId}")
	public TicketDetailResp getTicketDetailById(@PathVariable Integer ticketId) {
		
		return detailService.getTicketDetailById(ticketId);
	}
	
	@PostMapping("/detail")
	public void saveTicketDetail(@RequestBody TicketDetailReq request) {
		detailService.saveTicketDetail(request);
	}
	
	@PutMapping("/detail/{ticketId}")
	public void updateTicketDetail(@RequestBody TicketDetailReq request, @PathVariable Integer ticketId) {
		detailService.updateTicketDetail(request, ticketId);
	}
	
	@DeleteMapping("/detail/{ticketId}")
	public void deleteTicketDetail(@PathVariable Integer ticketId) {
		detailService.deleteTicketDetail(ticketId);
	}
	
}
