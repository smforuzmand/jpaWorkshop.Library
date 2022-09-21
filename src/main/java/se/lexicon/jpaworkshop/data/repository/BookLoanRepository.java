package se.lexicon.jpaworkshop.data.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpaworkshop.entity.Book;

public interface BookLoanRepository extends CrudRepository<Book , Integer> {
}
