package com.jesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesc.exception.CartItemException;
import com.jesc.exception.UserException;
import com.jesc.model.CartItem;
import com.jesc.model.User;
import com.jesc.response.ApiResponse;
import com.jesc.service.CartItemService;
import com.jesc.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@DeleteMapping("/{cartItemId}/delete")
	//@Operation(description = "Remove cart Item from Cart")
	//@io.swagger,v3.oas.annotations.responses.ApiResponse(description="Delete item")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
			@RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
		User user = userService.findUserProfileByJwt(jwt);
		cartItemService.removeCartItem(user.getId(), cartItemId);
		ApiResponse res = new ApiResponse();
		res.setMessage("Item deleted from cart");
		res.setStatus(true);
		return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
	}
	
	@PutMapping("/{cartItemId}")
	public ResponseEntity<CartItem> updateCartItem(
			@RequestBody CartItem req,
			@PathVariable Long cartItemId,
			@RequestHeader("Authorization") String jwt) throws UserException, CartItemException{
		User user = userService.findUserProfileByJwt(jwt);
		CartItem updatedCartItem =  cartItemService.update(user.getId(), cartItemId, req);
		return new ResponseEntity<CartItem>(updatedCartItem, HttpStatus.OK);
	}
}
