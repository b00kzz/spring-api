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

import com.morlam.model.BillRespModel;
import com.morlam.model.BillReqModel;
import com.morlam.service.BillSvc;

@RestController
public class BillController {
    
	@Autowired
	private BillSvc billService;
	
	// ดึงข้อมูลของ table bill ขึ้นมาทั้งหมด
	@GetMapping("/bill")
	public List<BillRespModel> getbillAll(){
		return billService.getBillAll();
	}
	
	// ดึงข้อมูลของ table bill ขึ้นมาตาม billId
	@GetMapping("/bill/{billId}")
	public BillRespModel getBillById(@PathVariable Integer billId) {
		
		return billService.getBillById(billId);
	}
	
	@PostMapping("/bill")
	public void saveBill(@RequestBody BillReqModel request) {
		billService.saveBill(request);
	}
	
	@PutMapping("/bill/{billId}")
	public void updateBill(@RequestBody BillReqModel request, @PathVariable Integer billId) {
		billService.updateBill(request, billId);
	}
	
	@DeleteMapping("/bill/{billId}")
	public void deletebill(@PathVariable Integer billId) {
		billService.deleteBill(billId);
	}
}
