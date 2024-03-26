package com.jesc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jesc.exception.ProductException;
import com.jesc.model.Review;
import com.jesc.model.User;
import com.jesc.request.ReviewRequest;

@Service
public interface ReviewService {
	public Review createReview(ReviewRequest req, User user) throws ProductException;
	public List<Review> getAllReview(Long productId);
}
