package com.casa.demospring.demo.repositories;

import com.casa.demospring.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
