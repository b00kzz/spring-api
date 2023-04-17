package com.morlam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_bill")
@Data
public class TblBillEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	private Integer billId;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "bill_status")
	private Integer billStatus;

    
}