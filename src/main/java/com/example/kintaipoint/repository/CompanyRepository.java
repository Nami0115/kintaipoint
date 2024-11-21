package com.example.kintaipoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintaipoint.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
}
