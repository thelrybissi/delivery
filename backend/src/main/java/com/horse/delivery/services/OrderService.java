package com.horse.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horse.delivery.dto.OrderDto;
import com.horse.delivery.entities.Order;
import com.horse.delivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll() {
		List<Order> listOrder = orderRepository.findAll();
		return listOrder.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
		
	}

}
