package com.morlam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morlam.entity.TblLoginEntity;

@Repository
public interface TblLoginRepository extends JpaRepository<TblLoginEntity, Integer>{

}
