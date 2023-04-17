package com.morlam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morlam.entity.TblBillEntity;

@Repository
public interface BillRepo extends JpaRepository<TblBillEntity, Integer> {

}
