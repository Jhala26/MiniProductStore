package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.exception.UserException;
import com.masai.model.Order;

public interface OrderService {

	public Order userPlacingOrder(String key) throws OrderException, UserException;
	
	public Order userCancellingOrder(Integer orderId, String key) throws OrderException, UserException;
	
	public List<Order> userViewingOrder(String key) throws OrderException, UserException;

	public Order adminViewingOrderById(Integer orderId, String key) throws OrderException, LoginException;
	
	public List<Order> adminViewingAllOrders(String key) throws OrderException, LoginException;
	
	
	
}
