package com.morlam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlam.entity.RoleEntity;
import com.morlam.model.RoleRequestModel;
import com.morlam.model.RoleResponeModel;
import com.morlam.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	public List<RoleResponeModel> getRoleAll(){
		
		List<RoleEntity> roleList = roleRepository.findAll();
		List<RoleResponeModel> responseList = null;
		
		if(null != roleList) {
			
			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();
			
			for(RoleEntity roleObj : roleList) {
				
				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				RoleResponeModel respObj = new RoleResponeModel();
				respObj.setRoleId(roleObj.getRoleId());
				respObj.setRoleName(roleObj.getRoleName());
				respObj.setRoleDesc(roleObj.getRoleDesc());
				respObj.setStatus(roleObj.getStatus());
				respObj.setCreateBy(roleObj.getCreateBy());
				
				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}
		
		return responseList;
	}
	
	public RoleResponeModel getRoleById(Integer roleId) {
		
		Optional<RoleEntity> roleEntity = roleRepository.findById(roleId);
		
		RoleResponeModel respone = null;
		
		if(roleEntity.isPresent()) {
			
			// roleEntity ต้องใช้ .get() ถึงจะใช้ตัว RoleEntity ได้
			RoleEntity entity = roleEntity.get();
			respone = new RoleResponeModel();
			respone.setRoleId(entity.getRoleId());
			respone.setRoleName(entity.getRoleName());
			respone.setRoleDesc(entity.getRoleDesc());
			respone.setStatus(entity.getStatus());
			respone.setCreateBy(entity.getCreateBy());
			respone.setCreateDate(entity.getCreateDate());
		}
		
		return respone;
	}
	
	public void saveRole(RoleRequestModel request) {
		
		if(null != request) {
			// request ก็คือ ตัวที่ได้ค่ามาจากหน้าบ้าน ที่เก็บไว้เป็น Object request
			
			RoleEntity entity = new RoleEntity();
			
			// new entity ขึ้นมาเพื่อที่จะเอาข้อมูลจาก Object request มาใส่แล้ว บันทึก
			entity.setRoleName(request.getRoleName());
			entity.setRoleDesc(request.getRoleDesc());
			entity.setStatus(request.getStatus());
			entity.setCreateBy("user");
			entity.setCreateDate(new Date());
			
			roleRepository.save(entity);
		}
		
	}
	
	public void updateRole(RoleRequestModel request, Integer roleId) {
		
		// findById เพื่อที่จะเอาข้อมูลเก่าขึ้นมา update
		Optional<RoleEntity> roleEntity = roleRepository.findById(roleId);
		
		if(roleEntity.isPresent()) {
			RoleEntity entity = roleEntity.get();
			
			if(null != request) {
				// set ค่าใหม่ที่มาจาก หน้าบ้าน
				entity.setRoleName(request.getRoleName());
				entity.setRoleDesc(request.getRoleDesc());
				entity.setUpdateBy("admin");
				entity.setUpdateDate(new Date());
				
			}
			
			roleRepository.save(entity);
		}
	}
	
	public void deleteRole(Integer roleId) {
		roleRepository.deleteById(roleId);
	}
	
}
