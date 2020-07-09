package ru.atf.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.atf.server.entity.Category;
import ru.atf.server.repository.CategoryRepository;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class CategoryController {
    private CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/category/{city_id}")
    public Iterable<Category> getByCity(@PathVariable int city_id){
        Integer[] citys = new Integer[]{city_id};
        Iterable<Integer> iter =  Arrays.asList(citys);
        return repository.findAllById( iter);
    }

    @GetMapping(value = "/categories")
    public Iterable<Category> getAll(){
        return repository.findAll();
    }
}
