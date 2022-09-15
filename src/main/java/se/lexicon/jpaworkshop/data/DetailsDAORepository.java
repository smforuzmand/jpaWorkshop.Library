package se.lexicon.jpaworkshop.data;


import se.lexicon.jpaworkshop.entity.Details;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;

@Repository
public class DetailsDAORepository implements DetailsDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional(readOnly = true)
    @Override
    public Details findById(int id) {

        if (id <= 0) throw new RuntimeException("Invalid");
        Details details = entityManager.find(Details.class, id);
        return details;

    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Details> findAll() {

        return entityManager.createQuery("SELECT d FROM Details d", Details.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Details create(Details details) {
        if (details == null) throw new IllegalArgumentException("details left null");
        entityManager.persist(details);
        return details;
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int id) {
        DetailsDAO detailsDAO = new DetailsDAORepository();
        entityManager.remove(detailsDAO.findById(id));
    }
}
