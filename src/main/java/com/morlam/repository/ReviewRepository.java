package com.morlam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morlam.entity.ReviewEntity;
@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer>{
    
}
