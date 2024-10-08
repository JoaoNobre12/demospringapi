package com.casa.demospring.demo.services;

import com.casa.demospring.demo.entities.Product;
import com.casa.demospring.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
//
//    public Product insert(Product obj) {
//        return repository.save(obj);
//    }
//
//    public void delete(Long id) {
//        try {
//            repository.deleteById(id);
//        } catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException(id);
//        } catch (DataIntegrityViolationException e) {
//            throw new DatabaseException(e.getMessage());
//        }
//    }
//
//    public Product update(Long id, Product obj) {
//        try {
//            Product entity = repository.getReferenceById(id);
//            updateData(entity, obj);
//            return repository.save(entity);
//        } catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException(id);
//        }
//    }
//
//    private void updateData(Product entity, Product obj) {
//        entity.setName(obj.getName());
//        entity.setEmail(obj.getEmail());
//        entity.setPhone(obj.getPhone());
//    }
}
