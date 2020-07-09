package ru.atf.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.atf.server.entity.Profile;
import ru.atf.server.repository.ProfileRepository;

import java.util.Optional;

@RestController
public class ProfileController {
    private ProfileRepository repository;

    @Autowired
    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }


    @GetMapping(value = "/profile/{id}")
    public Optional<Profile> getById(@PathVariable int id){
        return repository.findById(id);
    }
}
