package com.morlam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "tbl_review")
@Data
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rev_id")
	private Integer revId;
	
	@Column(name = "rev_rank")
	private String revRank;
	
	@Column(name = "rev_comment")
	private String revComment;
	
}
