package se.lexicon.jpaworkshop.data;

import se.lexicon.jpaworkshop.entity.Details;

import java.util.Collection;

public interface DetailsDAO {

    Details findById(int id);
    Collection<Details> findAll();
    Details create (Details details);
    Details update (Details details);
    void delete(int id);


}
