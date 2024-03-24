package com.jesc.service;

import java.util.List;

import com.jesc.exception.OrderException;
import com.jesc.model.Address;
import com.jesc.model.Order;
import com.jesc.model.User;

public interface OrderService {
	public Order createOrder(User user, Address shippingAddress);
	public Order findOrderById(Long id);
	public List<Order> userOrdershistory(Long userId);
	public Order placeOrder(Long orderId) throws OrderException;
	public Order confirmedOrder(Long orderId) throws OrderException;
	public Order shippedOrder(Long orderId) throws OrderException;
	public Order deliveredOrder(Long orderId) throws OrderException;
	public Order canceledOrder(Long orderId) throws OrderException;
	public List<Order> 	getAllOrders();
	public void DeleteOrder(Long orderId) throws OrderException;
	
	
}
