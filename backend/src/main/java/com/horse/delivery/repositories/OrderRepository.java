package com.horse.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horse.delivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
