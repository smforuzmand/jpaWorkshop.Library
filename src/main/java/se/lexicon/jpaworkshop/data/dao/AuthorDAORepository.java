package se.lexicon.jpaworkshop.data.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaworkshop.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
public class AuthorDAORepository implements AuthorDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public Author findById(int authorId) {
        return entityManager.find(Author.class, authorId);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();

    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Author create(Author author) {

        entityManager.persist(author);

        return author;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int authorId) {
        entityManager.remove(findById(authorId));

    }
}
