package com.casa.demospring.demo.repositories;

import com.casa.demospring.demo.entities.Order;
import com.casa.demospring.demo.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
