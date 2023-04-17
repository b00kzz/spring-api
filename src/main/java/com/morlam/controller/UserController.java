package com.morlam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.morlam.model.UserRequestModel;
import com.morlam.model.UserResponeModel;
import com.morlam.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	// ดึงข้อมูลของ table Role ขึ้นมาทั้งหมด
	@GetMapping("/users")
	public List<UserResponeModel> getUserAll(){
		return userService.getUserAll();
	}

    	// ดึงข้อมูลของ table Role ขึ้นมาตาม RoleId
	@GetMapping("/user/{Id}")
	public UserResponeModel getUserById(@PathVariable Integer Id) {
		
		return userService.getUserById(Id);
	}
	
	@PostMapping("/saveuser")
	public void saveUser(@RequestBody UserRequestModel request) {
		userService.saveUser(request);
	}
	
	@PutMapping("/user/{Id}")
	public void updateUser(@RequestBody UserRequestModel request, @PathVariable Integer Id) {
		userService.updateUser(request, Id);
	}
	
	@DeleteMapping("/user/{Id}")
	public void deleteUser(@PathVariable Integer Id) {
		userService.deleteUser(Id);
	}
}
