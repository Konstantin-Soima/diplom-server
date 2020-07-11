package ru.atf.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.atf.server.entity.Ads;
import ru.atf.server.entity.Profile;
import ru.atf.server.repository.ProfileRepository;

import java.util.Date;
import java.util.Optional;

@RestController
public class ProfileController {
    private ProfileRepository repository;

    @Autowired
    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

   @PostMapping(path = "/addProfile")
   @ResponseStatus(HttpStatus.CREATED)
   public void addProfile(@RequestBody Profile pro) {
        repository.save(pro);

   }

    @GetMapping(value = "/profile/{id}")
    public Optional<Profile> getById(@PathVariable int id){
        return repository.findById(id);
    }
}
