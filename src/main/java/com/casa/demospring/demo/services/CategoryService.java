package com.casa.demospring.demo.services;

import com.casa.demospring.demo.entities.Category;
import com.casa.demospring.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
//
//    public Category insert(Category obj) {
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
//    public Category update(Long id, Category obj) {
//        try {
//            Category entity = repository.getReferenceById(id);
//            updateData(entity, obj);
//            return repository.save(entity);
//        } catch (EntityNotFoundException e) {
//            throw new ResourceNotFoundException(id);
//        }
//    }
//
//    private void updateData(Category entity, Category obj) {
//        entity.setName(obj.getName());
//        entity.setEmail(obj.getEmail());
//        entity.setPhone(obj.getPhone());
//    }
}
