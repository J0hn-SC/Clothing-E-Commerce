package com.jesc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jesc.exception.OrderException;
import com.jesc.model.Address;
import com.jesc.model.Cart;
import com.jesc.model.CartItem;
import com.jesc.model.Order;
import com.jesc.model.OrderItem;
import com.jesc.model.User;
import com.jesc.repository.AddressRepository;
import com.jesc.repository.CartRepository;
import com.jesc.repository.OrderItemRepository;
import com.jesc.repository.OrderRepository;
import com.jesc.repository.UserRepository;

@Service
public class OrderServiceImplementation implements OrderService{
	
	private OrderRepository orderRepository;
	private CartService cartService;
	private CartRepository cartRepository;
	private AddressRepository addressRepository;
	private UserRepository userRepository;
	private OrderItemService orderItemService;
	private OrderItemRepository orderItemRepository;
	//private CartItemService cartItemService;
	//private ProductService productService;
	
	public OrderServiceImplementation(OrderRepository orderRepository,
			CartService cartService,
			CartRepository cartRepository,
			AddressRepository addressRepository,
			UserRepository userRepository,
			OrderItemService orderItemService,
			OrderItemRepository orderItemRepository
			//CartItemService cartItemService,
			//ProductService productService
			) {
	this.orderRepository = orderRepository;
	this.cartService = cartService;
	this.cartRepository = cartRepository;
	this.addressRepository = addressRepository;
	this.userRepository = userRepository;
	this.orderItemService = orderItemService;
	this.orderItemRepository = orderItemRepository;
	//this.cartItemService = cartItemService;
	//this.productService = productService;
	}
	
	@Override
	public Order createOrder(User user, Address shippingAddress) {
		shippingAddress.setUser(user);
		Address address = addressRepository.save(shippingAddress);
		user.getAddress().add(address);
		userRepository.save(user);
		
		Cart cart = cartService.findUserCart(user.getId());
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(CartItem item : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setPrice(item.getPrice());
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setSize(item.getSize());
			orderItem.setUserId(item.getUserId());
			orderItem.setDiscountedPrice(item.getDiscountedPrice());
			OrderItem createdOrderItem = orderItemRepository.save(orderItem);
			orderItems.add(createdOrderItem);
			
		}
		
		Order createdOrder = new Order();
		createdOrder.setUser(user);
		createdOrder.setOrderItems(orderItems);
		createdOrder.setTotalPrice(cart.getTotalPrice());
		createdOrder.setTotalDiscountPrice(cart.getTotalDiscountedPrice());
		createdOrder.setDiscount(cart.getDiscount());
		createdOrder.setTotalItem(cart.getTotalItem());
		
		createdOrder.setShippingAddress(shippingAddress);
		createdOrder.setOrderDate(LocalDateTime.now());
		createdOrder.setOrderStatus("PENDING");
		createdOrder.getPaymentDetails().setStatus("PENDING");
		createdOrder.setCreatedAt(LocalDateTime.now());
		
		Order savedOrder = orderRepository.save(createdOrder);
		for(OrderItem item : orderItems) {
			item.setOrder(savedOrder);
			orderItemRepository.save(item);
		}
		return savedOrder;
	}

	@Override
	public Order findOrderById(Long id)  throws OrderException{
		Optional<Order> opt = orderRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new OrderException("Order not exist with id " + id);
	}

	@Override
	public List<Order> userOrdersHistory(Long userId) {
		List<Order> orders = orderRepository.getUserOrders(userId);
		return orders;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus("PLACED");
		order.getPaymentDetails().setStatus("COMPLETED");
		return order;
	}

	@Override
	public Order confirmedOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus("CONFIRMED");
		return orderRepository.save(order);
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus("SHIPPED");
		return orderRepository.save(order);
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus("DELIVERED");
		return orderRepository.save(order);
	}

	@Override
	public Order canceledOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus("CANCELED");
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public void DeleteOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		orderRepository.deleteById(orderId);
	}
	
}
