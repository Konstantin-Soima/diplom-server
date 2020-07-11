package ru.atf.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atf.server.entity.Ads;

import java.util.Optional;

public interface AdsRepository extends CrudRepository<Ads,Integer> {
    Optional<Ads> findByLink(String link);
}
