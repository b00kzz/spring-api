package com.morlam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_desc")
	private String roleDesc;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "create_by")
	private String createBy;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_by")
	private String updateBy;
	
	@Column(name = "update_date	")
	private Date updateDate;
}
