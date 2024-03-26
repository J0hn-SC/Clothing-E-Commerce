package com.jesc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesc.exception.OrderException;
import com.jesc.exception.UserException;
import com.jesc.model.Address;
import com.jesc.model.Order;
import com.jesc.model.User;
import com.jesc.service.OrderService;
import com.jesc.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,
			@RequestHeader("Authorization") String jwt) throws UserException{
		User user = userService.findUserProfileByJwt(jwt);
		Order order = orderService.createOrder(user, shippingAddress);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Order>> usersOrderHistory(
			@RequestHeader("Authorization") String jwt) throws UserException{
		User user = userService.findUserProfileByJwt(jwt);
		List<Order> orders = orderService.userOrdersHistory(user.getId());
		return new ResponseEntity<List<Order>>(orders, HttpStatus.CREATED);
	}
	@GetMapping("/{Id}")
	public ResponseEntity<Order> findOrderById(
			@RequestHeader("Authorization") String jwt, 
			@PathVariable Long Id) throws UserException, OrderException{
		User user = userService.findUserProfileByJwt(jwt);
		Order order = orderService.findOrderById(Id);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
}
