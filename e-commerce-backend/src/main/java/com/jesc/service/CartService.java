package com.jesc.service;

import com.jesc.exception.ProductException;
import com.jesc.model.Cart;
import com.jesc.model.User;
import com.jesc.request.AddItemRequest;

public interface CartService {
	public Cart createCart(User user);
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	public Cart findUserCart(Long userId);
}
