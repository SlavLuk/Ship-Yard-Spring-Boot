package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderRepository;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	public List<OrderInfo> findAllOrderInfo(){
		
		 List<OrderInfo> orders = (List<OrderInfo>) orderRepository.findAll();
		  
		  return orders;
		
		
	}
	
	public OrderInfo addOrder(OrderInfo o){
		
		return orderRepository.save(o);
	}
}
