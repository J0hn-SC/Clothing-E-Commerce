package com.jesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesc.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
