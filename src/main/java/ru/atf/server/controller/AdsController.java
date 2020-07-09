package ru.atf.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.atf.server.entity.Ads;
import ru.atf.server.repository.AdsRepository;

import java.util.Optional;

@RestController
public class AdsController {
    private AdsRepository repository;

    @Autowired
    public AdsController(AdsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/ads/{id}")
    public Optional<Ads> getById(@PathVariable int id){
        return repository.findById(id);
    }
}
