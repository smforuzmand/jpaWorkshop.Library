package se.lexicon.jpaworkshop.data.dao;

import se.lexicon.jpaworkshop.entity.BookLoan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;
@Repository
public class BookLoanDAOsRepository implements BookLoanDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public BookLoan findById(int id) {

        BookLoan bookLoan = entityManager.find(BookLoan.class, id);
        return bookLoan;

    }
    @Transactional(readOnly = true)
    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", BookLoan.class).getResultList();
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BookLoan create(BookLoan bookLoanCreate) {

        entityManager.persist(bookLoanCreate);
        return bookLoanCreate;
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BookLoan update(BookLoan bookLoanUpdate) {
        return null;
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int toBeDeleted) {

    }
}
