package ru.atf.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atf.server.entity.Profile;

public interface ProfileRepository extends CrudRepository<Profile,Integer> {
}
