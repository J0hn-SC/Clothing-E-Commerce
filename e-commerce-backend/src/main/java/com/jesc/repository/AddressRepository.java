package com.jesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesc.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
}
