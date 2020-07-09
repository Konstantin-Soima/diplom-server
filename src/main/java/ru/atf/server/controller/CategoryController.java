package ru.atf.server.controller;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.atf.server.entity.Category;
import ru.atf.server.repository.CategoryRepository;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@RestController
public class CategoryController {
    private CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/category/{city_id}")
    public Iterable<Category> getByCity(@PathVariable int city_id){
        Optional<Category> categoryOptional = repository.findByCityId(city_id);
        return categoryOptional.map(Collections::singleton)
                .orElseGet(Collections::emptySet);
    }

    @GetMapping(value = "/categories")
    public Iterable<Category> getAll(){
        return repository.findAll();
    }
}
