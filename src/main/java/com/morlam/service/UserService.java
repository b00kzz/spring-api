package com.morlam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morlam.entity.UserEntity;
import com.morlam.model.UserRequestModel;
import com.morlam.model.UserResponeModel;
import com.morlam.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    public List<UserResponeModel> getUserAll(){
		
		List<UserEntity> userList = userRepository.findAll();
		List<UserResponeModel> responseList = null;
		
		if(null != userList) {
			
			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();
			
			for(UserEntity userObj : userList) {
				
				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				UserResponeModel respObj = new UserResponeModel();
                respObj.setId(userObj.getId());
                respObj.setFirstName(userObj.getFirstName());
                respObj.setLastName(userObj.getLastName());
                respObj.setGender(userObj.getGender());
                respObj.setAddress(userObj.getAddress());
                respObj.setPhone(userObj.getPhone());
				respObj.setAvatar(userObj.getAvatar());
				respObj.setStatus(userObj.getStatus());

				// respObj.setCreateBy(userObj.getCreateBy());
				
				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}
		
		return responseList;
	}

    public UserResponeModel getUserById(Integer Id) {
		
		Optional<UserEntity> roleEntity = userRepository.findById(Id);
		
		UserResponeModel respone = null;
		
		if(roleEntity.isPresent()) {
			
			// roleEntity ต้องใช้ .get() ถึงจะใช้ตัว RoleEntity ได้
			UserEntity entity = roleEntity.get();
			respone = new UserResponeModel();
			respone.setId(entity.getId());
			respone.setFirstName(entity.getFirstName());
			respone.setLastName(entity.getLastName());
			respone.setGender(entity.getGender());
			respone.setAddress(entity.getAddress());
            respone.setPhone(entity.getPhone());
			respone.setAvatar(entity.getAvatar());
			respone.setStatus(entity.getStatus());
		}
		
		return respone;
	}

    public void saveUser(UserRequestModel request) {
		
		if(null != request) {
			// request ก็คือ ตัวที่ได้ค่ามาจากหน้าบ้าน ที่เก็บไว้เป็น Object request
			
			UserEntity entity = new UserEntity();
			
			// new entity ขึ้นมาเพื่อที่จะเอาข้อมูลจาก Object request มาใส่แล้ว บันทึก
			entity.setFirstName(request.getFirstName());
			entity.setLastName(request.getLastName());
			entity.setGender(request.getGender());
			entity.setAddress(request.getAddress());
            entity.setPhone(request.getPhone());
			entity.setAvatar(request.getAvatar());
			entity.setStatus(request.getStatus());
			
			userRepository.save(entity);
		}
		
	}

    public void updateUser(UserRequestModel request, Integer Id) {
		
		// findById เพื่อที่จะเอาข้อมูลเก่าขึ้นมา update
		Optional<UserEntity> userEntity = userRepository.findById(Id);
		
		if(userEntity.isPresent()) {
			UserEntity entity = userEntity.get();
			
			if(null != request) {
				// set ค่าใหม่ที่มาจาก หน้าบ้าน
                entity.setAddress(request.getAddress());
                entity.setPhone(request.getPhone());
				entity.setAvatar(request.getAvatar());
				
			}
			
			userRepository.save(entity);
		}
	}

    public void deleteUser(Integer Id) {
		userRepository.deleteById(Id);
	}

}
