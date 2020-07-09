package ru.atf.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atf.server.entity.Category;

public interface CategoryRepository  extends CrudRepository<Category,Integer> {
}
