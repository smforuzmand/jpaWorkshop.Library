package se.lexicon.jpaworkshop.data.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpaworkshop.entity.Details;

public interface DetailsRepository extends CrudRepository<Details, Integer> {
}
