package com.dao;

import java.util.List;

// Spring Data JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.EmployeeEntity;

public interface MagicDaoRepository extends JpaRepository<EmployeeEntity,Integer>{

	EmployeeEntity findByEmailAndPassword(String email, String password);
	
}
