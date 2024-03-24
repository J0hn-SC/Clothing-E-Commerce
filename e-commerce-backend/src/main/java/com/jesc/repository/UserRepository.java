package com.jesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesc.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findByEmail(String email);
}
