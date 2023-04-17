package com.morlam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlam.entity.TicketDetail;
import com.morlam.model.TicketDetailReq;
import com.morlam.model.TicketDetailResp;
import com.morlam.repository.TicketDetailRepo;

@Service
public class TicketDetailScv {
	@Autowired
	private TicketDetailRepo ticketDetailRepo;

	public List<TicketDetailResp> getTicketDetailAll() {

		List<TicketDetail> detailList = ticketDetailRepo.findAll();
		List<TicketDetailResp> responseList = null;

		if (null != detailList) {

			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();

			for (TicketDetail ticketObj : detailList) {

				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				TicketDetailResp respObj = new TicketDetailResp();
				respObj.setTicketId(ticketObj.getTicketId());
				respObj.setTicketName(ticketObj.getTicketName());
				respObj.setTicketType(ticketObj.getTicketType());
				respObj.setTicketPrice(ticketObj.getTicketPrice());
				respObj.setTicketDesc(ticketObj.getTicketDesc());

				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}

		return responseList;
	}

	public TicketDetailResp getTicketDetailById(Integer ticketId) {

		Optional<TicketDetail> tDEntity = ticketDetailRepo.findById(ticketId);

		TicketDetailResp respone = null;

		if (tDEntity.isPresent()) {

			// roleEntity ต้องใช้ .get() ถึงจะใช้ตัว RoleEntity ได้
			TicketDetail entity = tDEntity.get();
			respone = new TicketDetailResp();
			respone.setTicketId(entity.getTicketId());
			respone.setTicketName(entity.getTicketName());
			respone.setTicketType(entity.getTicketType());
			respone.setTicketPrice(entity.getTicketPrice());
			respone.setTicketDesc(entity.getTicketDesc());

		}

		return respone;
	}

	public void saveTicketDetail(TicketDetailReq request) {

		if (null != request) {
			// request ก็คือ ตัวที่ได้ค่ามาจากหน้าบ้าน ที่เก็บไว้เป็น Object request

			TicketDetail entity = new TicketDetail();

			// new entity ขึ้นมาเพื่อที่จะเอาข้อมูลจาก Object request มาใส่แล้ว บันทึก
			entity.setTicketName(request.getTicketName());
			entity.setTicketType(request.getTicketType());
			entity.setTicketPrice(request.getTicketPrice());
			entity.setTicketDesc(request.getTicketDesc());

			ticketDetailRepo.save(entity);
		}

	}

	public void updateTicketDetail(TicketDetailReq request, Integer ticketId) {

		// findById เพื่อที่จะเอาข้อมูลเก่าขึ้นมา update
		Optional<TicketDetail> ticketDetailEntity = ticketDetailRepo.findById(ticketId);

		if (ticketDetailEntity.isPresent()) {
			TicketDetail entity = ticketDetailEntity.get();

			if (null != request) {
				// set ค่าใหม่ที่มาจาก หน้าบ้าน

				entity.setTicketName(request.getTicketName());
				entity.setTicketType(request.getTicketType());
				entity.setTicketPrice(request.getTicketPrice());
				entity.setTicketDesc(request.getTicketDesc());

			}

			ticketDetailRepo.save(entity);
		}
	}

	public void deleteTicketDetail(Integer ticketId) {
		ticketDetailRepo.deleteById(ticketId);
	}

}