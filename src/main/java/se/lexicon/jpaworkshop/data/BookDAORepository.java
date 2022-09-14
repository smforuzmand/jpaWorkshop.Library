package se.lexicon.jpaworkshop.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.util.Collection;
@Repository
public class BookDAORepository implements BookDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public Book findById(int id) {

        if (id <= 0) throw new RuntimeException("Invalid");
        Book book = entityManager.find(Book.class, id);
        return book;

    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Book> findAll() {

        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();

    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Book create(Book bookCreate) {
        entityManager.persist(bookCreate);
        return bookCreate;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Book update(Book bookUpdate) {
        return entityManager.merge(bookUpdate);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int toBeDeleted) {

        entityManager.remove(findById(toBeDeleted));

    }
}
