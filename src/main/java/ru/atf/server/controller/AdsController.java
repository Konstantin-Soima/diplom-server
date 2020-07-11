package ru.atf.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.atf.server.entity.Ads;
import ru.atf.server.entity.Profile;
import ru.atf.server.repository.AdsRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
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

    @PostMapping(path = "/addAds")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProfile(@RequestBody Ads ad) {
        repository.save(ad);

    }
    @RequestMapping("/adsByUrl")
    public @ResponseBody Optional<Ads> getByUrl(@RequestParam String url) {
        Optional<Ads> adsOptional = repository.findByLink(url);

        return adsOptional;
    }
    //https://avito.ru/sankt-peterburg/muzykalnye_instrumenty/audiointerfeys_line6_pod_studio_ux2_772723283
    /*@GetMapping(value = "/adsByUrl/{url}")
    public Optional<Ads> getByUrl(@PathVariable String url){
        Optional<Ads> adsOptional = repository.findByLink(url);

        return adsOptional;
    }*/
    /*@PostMapping(path = "/addAds")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAds(@RequestBody String ads) {
        ObjectMapper objectMapper = new ObjectMapper();
        Ads ad = null;
        try {
            ad = objectMapper.readValue(ads, Ads.class);
            if (ad.getDate() == null) ad.setDate(new Date());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (ad!=null) {
            System.out.println(ads);
            System.out.println(ad);
            repository.save(ad);
            System.out.println("ДОБАВЛЕННО!!!");
        } else{
            System.out.println("НЕ ДОБАВЛЕННО!!!");
        }
    }*/
}
