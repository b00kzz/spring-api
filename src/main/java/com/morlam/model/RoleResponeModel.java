package com.morlam.model;

import java.util.Date;

import lombok.Data;

@Data
public class RoleResponeModel {

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private String status;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;

}
