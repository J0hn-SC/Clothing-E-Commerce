package com.jesc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jesc.exception.ProductException;
import com.jesc.model.Rating;
import com.jesc.model.User;
import com.jesc.request.RatingRequest;

@Service
public interface RatingService {
	public Rating createRating(RatingRequest req, User user) throws ProductException;
	public List<Rating> getProductRating(Long ProductId);
}
