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
import java.util.*;

@RestController
public class CategoryController {
    private CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/categoryByIds/{ids}")
    public Iterable<Category> getAll(@PathVariable String ids){
        String[] arrayStr = ids.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for(String s : arrayStr) list.add(Integer.valueOf(s));
        return repository.findAllById(list);
    }

    @GetMapping(value = "/categoryByCity/{city_id}")
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
