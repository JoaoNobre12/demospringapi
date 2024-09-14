package com.casa.demospring.demo.repositories;

import com.casa.demospring.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
