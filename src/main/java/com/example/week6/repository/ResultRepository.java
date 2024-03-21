package com.example.week6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.week6.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer>{
    
}
