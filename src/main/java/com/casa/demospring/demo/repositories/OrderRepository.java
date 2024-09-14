package com.casa.demospring.demo.repositories;

import com.casa.demospring.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
