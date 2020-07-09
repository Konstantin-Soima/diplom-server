package ru.atf.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atf.server.entity.Ads;

public interface AdsRepository extends CrudRepository<Ads,Integer> {
}
