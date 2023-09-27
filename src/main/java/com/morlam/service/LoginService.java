package com.morlam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.morlam.entity.TblLoginEntity;
import com.morlam.entity.UserEntity;
import com.morlam.model.LoginRequestModel;
import com.morlam.model.LoginResponeModel;
import com.morlam.repository.TblLoginRepository;
import com.morlam.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private TblLoginRepository tblLoginRepository;
	@Autowired 
	private UserRepository userRepository;

	public List<LoginResponeModel> getLoginAll(){
		
		List<TblLoginEntity> loginList = tblLoginRepository.findAll();
		List<LoginResponeModel> responseList = null;
		
		if(null != loginList) {
			
			// new ArrayList เพื่อที่จะเอาไปใช้บรรทัด 42
			responseList = new ArrayList<>();
			
			for(TblLoginEntity loginObj : loginList) {
				
				// สร้าง ตัว RespObject เพื่อที่จะเอาไป เพิ่มใส่ใน List
				LoginResponeModel respObj = new LoginResponeModel();
				respObj.setUserId(loginObj.getUserId());
				respObj.setUsername(loginObj.getUsername());
				respObj.setPassword(loginObj.getPassword());
				respObj.setStatus(loginObj.getStatus());
				respObj.setCreateBy(loginObj.getCreateBy());
				respObj.setCreateDate(loginObj.getCreateDate());
				
				
				// เพิ่มข้อมูลที่ได้จาก ตัว respObj ที่set จากด้านบน
				responseList.add(respObj);
			}
		}
		
		return responseList;
	}
	
	public LoginResponeModel getLoginById(Integer id) {

		LoginResponeModel model = new LoginResponeModel();
		
		TblLoginEntity entity = tblLoginRepository.findById(id).orElse(null);
		
		if(null != entity) {
			model.setUserId(entity.getUserId());
			model.setUsername(entity.getUsername());
			model.setPassword(entity.getPassword());
			model.setStatus(entity.getStatus());
			model.setCreateBy(entity.getCreateBy());
			model.setCreateDate(entity.getCreateDate());
		}

		return model;
	}
	
	public void save(LoginRequestModel request) {
		
		TblLoginEntity entity = new TblLoginEntity();
		UserEntity userRe = new UserEntity(); 
			
		

		entity.setUsername(request.getUsername());
		entity.setPassword(request.getPassword());
		entity.setStatus("user");
		entity.setCreateBy("System");
		entity.setCreateDate(new Date());

		////////////////////////////////////////////////////////
		entity = tblLoginRepository.save(entity);
		userRe.setAvatar("getUserId()");
		userRepository.save(userRe);
	}

	public void deletelogin(Integer Id) {
		tblLoginRepository.deleteById(Id);
	}
}
