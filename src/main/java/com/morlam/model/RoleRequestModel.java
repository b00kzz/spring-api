package com.morlam.model;


import lombok.Data;

@Data
public class RoleRequestModel {

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private String status;
}
