package com.morlam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlam.entity.TicketBuyEntity;
import com.morlam.model.TicketBuyResModel;
import com.morlam.repository.TicketBuyRepository;

@Service
public class TicketBuyService {
    @Autowired
	TicketBuyRepository ticketBuyRepository;
	
	
	public List<TicketBuyResModel> getTicketAll(){
		
		List<TicketBuyEntity> ticketList = ticketBuyRepository.findAll();
		List<TicketBuyResModel> responseList = null;
		
		if(null != ticketList) {
			
			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();
			
			for(TicketBuyEntity ticketObj : ticketList) {
				
				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				TicketBuyResModel respObj = new TicketBuyResModel();
                respObj.setBuyId(ticketObj.getBuyId());
                respObj.setBuyStatus(ticketObj.getBuyStatus());
                respObj.setBuyDate(ticketObj.getBuyDate());
				
				
				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}
		
		return responseList;
	}
	
	public TicketBuyResModel getTicketById(Integer buyId) {
		
		Optional<TicketBuyEntity> ticketEntity = ticketBuyRepository.findById(buyId);
		
		TicketBuyResModel respone = null;
		
		if(ticketEntity.isPresent()) {
			
			// roleEntity ต้องใช้ .get() ถึงจะใช้ตัว RoleEntity ได้
			TicketBuyEntity entity = ticketEntity.get();
			respone = new TicketBuyResModel();
            respone.setBuyId(entity.getBuyId());
            respone.setBuyStatus(entity.getBuyStatus());
            respone.setBuyDate(entity.getBuyDate());
		
		}
		
		return respone;
	}
	
	public void saveTicketBuy(TicketBuyResModel request) {
		
		if(null != request) {
			// request ก็คือ ตัวที่ได้ค่ามาจากหน้าบ้าน ที่เก็บไว้เป็น Object request
			
			TicketBuyEntity entity = new TicketBuyEntity();
			
			// new entity ขึ้นมาเพื่อที่จะเอาข้อมูลจาก Object request มาใส่แล้ว บันทึก
			
			entity.setBuyId(request.getBuyId());
            entity.setBuyStatus(request.getBuyStatus());
            entity.setBuyDate(new Date());
			ticketBuyRepository.save(entity);
		}
		
	}
	
	public void updateTicket(TicketBuyResModel request, Integer buyId) {
		
		// findById เพื่อที่จะเอาข้อมูลเก่าขึ้นมา update
		Optional<TicketBuyEntity> ticketBuyEntity = ticketBuyRepository.findById(buyId);
		
		if(ticketBuyEntity.isPresent()) {
			TicketBuyEntity entity = ticketBuyEntity.get();
			
			if(null != request) {
				// set ค่าใหม่ที่มาจาก หน้าบ้าน
                entity.setBuyStatus(request.getBuyStatus());
                entity.setBuyDate(request.getBuyDate());
				
				
			}
			
			ticketBuyRepository.save(entity);
		}
	}
	
	public void deleteTicket(Integer buyId) {
		ticketBuyRepository.deleteById(buyId);
	}
}
