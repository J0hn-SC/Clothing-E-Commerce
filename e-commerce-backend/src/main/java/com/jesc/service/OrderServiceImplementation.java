package com.jesc.service;

import java.util.List;

import com.jesc.exception.OrderException;
import com.jesc.model.Address;
import com.jesc.model.Order;
import com.jesc.model.User;
import com.jesc.repository.CartRepository;


public class OrderServiceImplementation implements OrderService{
	
	private CartRepository cartRepository;
	private CartItemService cartItemService;
	private ProductService productService;
	
	public OrderServiceImplementation(CartRepository cartRepository, 
			CartItemService cartItemService,
			ProductService productService) {
		
	this.cartRepository = cartRepository;
	this.cartItemService = cartItemService;
	this.productService = productService;
	}
	
	@Override
	public Order createOrder(User user, Address shippingAddress) {
		
		return null;
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> userOrdershistory(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order placeOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order confirmedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order canceledOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteOrder(Long orderId) throws OrderException {
		// TODO Auto-generated method stub
		
	}
	
}
