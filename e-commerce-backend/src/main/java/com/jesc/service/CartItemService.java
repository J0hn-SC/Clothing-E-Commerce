package com.jesc.service;

import com.jesc.exception.CartItemException;
import com.jesc.exception.UserException;
import com.jesc.model.Cart;
import com.jesc.model.CartItem;
import com.jesc.model.Product;

public interface CartItemService {
	public CartItem createCartItem(CartItem cartItem);
	public CartItem update(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
