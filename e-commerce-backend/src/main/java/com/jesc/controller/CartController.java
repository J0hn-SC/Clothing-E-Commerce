package com.jesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesc.exception.ProductException;
import com.jesc.exception.UserException;
import com.jesc.model.Cart;
import com.jesc.model.User;
import com.jesc.request.AddItemRequest;
import com.jesc.response.ApiResponse;
import com.jesc.service.CartService;
import com.jesc.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/cart")
//@Tag(name = "Cart Managment", description = "Find user cart, add item to Cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	//@Operation(description = "Find cart by user Id")
	public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException{
		User user = userService.findUserProfileByJwt(jwt);
		Cart cart = cartService.findUserCart(user.getId());
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/add")
	//@Operation(description = "add item to cart")
	public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req,
			@RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		User user = userService.findUserProfileByJwt(jwt);
		cartService.addCartItem(user.getId(), req);
		
		ApiResponse res = new ApiResponse();
		res.setMessage("Item added to cart");
		res.setStatus(true);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
