package se.lexicon.jpaworkshop.data;

import se.lexicon.jpaworkshop.entity.BookLoan;

import java.util.Collection;

public interface BookLoanDAO {
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoanCreate);
    BookLoan update(BookLoan bookLoanUpdate);
    void delete(int toBeDeleted);
}
