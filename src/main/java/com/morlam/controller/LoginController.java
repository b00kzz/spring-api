package com.morlam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morlam.model.LoginRequestModel;
import com.morlam.model.LoginResponeModel;
import com.morlam.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/logins")
	public List<LoginResponeModel> getLoginAll(){
		return loginService.getLoginAll();
	}

	@GetMapping("/login/{id}")
	public LoginResponeModel getLoginById(@PathVariable Integer id) {
		
		return loginService.getLoginById(id);
	}
	
	@PostMapping("/login")
	public void save(@RequestBody LoginRequestModel request) {
		loginService.save(request);
	}
	@DeleteMapping("/login/{Id}")
    public void deletelogin(@PathVariable Integer Id) {
        loginService.deletelogin(Id);
    }
}
