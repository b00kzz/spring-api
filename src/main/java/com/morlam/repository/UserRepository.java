package com.morlam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morlam.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}
