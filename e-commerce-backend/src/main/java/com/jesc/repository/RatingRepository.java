package com.jesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesc.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{
	
}
