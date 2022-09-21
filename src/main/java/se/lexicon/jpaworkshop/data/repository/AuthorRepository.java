package se.lexicon.jpaworkshop.data.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpaworkshop.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
