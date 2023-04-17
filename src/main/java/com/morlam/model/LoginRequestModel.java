package com.morlam.model;

import lombok.Data;

@Data
public class LoginRequestModel {
	
	private Integer id;
	private String username;
	private String password;
}
