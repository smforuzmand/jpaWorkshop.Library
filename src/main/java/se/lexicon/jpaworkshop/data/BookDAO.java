package se.lexicon.jpaworkshop.data;

import java.awt.print.Book;
import java.util.Collection;

public interface BookDAO {
    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book bookCreate);
    Book update(Book bookUpdate);
    void delete(int toBeDeleted);

}
