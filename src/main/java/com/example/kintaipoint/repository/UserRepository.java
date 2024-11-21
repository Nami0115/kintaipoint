package com.example.kintaipoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintaipoint.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);	
}
