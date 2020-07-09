package ru.atf.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atf.server.entity.City;
import ru.atf.server.repository.CityRepository;

@RestController
public class CityController {
    private CityRepository repository;

    @Autowired
    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/city")
    public Iterable<City> getAll(){
        return repository.findAll();
    }
}
