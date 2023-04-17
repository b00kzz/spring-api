package com.morlam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlam.entity.TblBillEntity;
import com.morlam.model.BillReqModel;
import com.morlam.model.BillRespModel;
import com.morlam.repository.BillRepo;

@Service
public class BillSvc {
    @Autowired
    private BillRepo billRepo;
    public List<BillRespModel> getBillAll(){
		
		List<TblBillEntity> billList = billRepo.findAll();
		List<BillRespModel> responseList = null;
		
		if(null != billList) {
			
			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();
			
			for(TblBillEntity billObj : billList) {
				
				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				BillRespModel respObj = new BillRespModel();
                respObj.setBillId(billObj.getBillId());
                respObj.setImage(billObj.getImage());
                respObj.setBillStatus(billObj.getBillStatus());
				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}
		
		return responseList;
	}

    public BillRespModel getBillById(Integer billId) {
		
		Optional<TblBillEntity> billEntity = billRepo.findById(billId);
		
		BillRespModel respone = null;
		
		if(billEntity.isPresent()) {
			
			// roleEntity ต้องใช้ .get() ถึงจะใช้ตัว RoleEntity ได้
			TblBillEntity entity = billEntity.get();
			respone = new BillRespModel();
            respone.setBillId(entity.getBillId());
            respone.setImage(entity.getImage());
            respone.setBillStatus(entity.getBillStatus());
		}
		
		return respone;
	}
	
	public void saveBill(BillReqModel request) {
		
		if(null != request) {
			// request ก็คือ ตัวที่ได้ค่ามาจากหน้าบ้าน ที่เก็บไว้เป็น Object request
			
			TblBillEntity entity = new TblBillEntity();
			
			// new entity ขึ้นมาเพื่อที่จะเอาข้อมูลจาก Object request มาใส่แล้ว บันทึก
            entity.setBillId(request.getBillId());
            entity.setImage(request.getImage());
            entity.setBillStatus(request.getBillStatus());
			
			billRepo.save(entity);
		}
		
	}

    public void updateBill(BillReqModel request, Integer billId) {
		
		// findById เพื่อที่จะเอาข้อมูลเก่าขึ้นมา update
		Optional<TblBillEntity> billEntity = billRepo.findById(billId);
		
		if(billEntity.isPresent()) {
			TblBillEntity entity = billEntity.get();
			
			if(null != request) {
				// set ค่าใหม่ที่มาจาก หน้าบ้าน
                entity.setImage(request.getImage());
                entity.setBillStatus(request.getBillStatus());

				
			}
			
			billRepo.save(entity);
		}
	}
	
	public void deleteBill(Integer billId) {
		billRepo.deleteById(billId);
	}

}
