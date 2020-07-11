package ru.atf.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.atf.server.entity.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends CrudRepository<Category,Integer> {
    Iterable<Category> findByCityId(Integer City_id);

}
