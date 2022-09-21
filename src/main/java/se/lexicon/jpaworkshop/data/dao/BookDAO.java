package se.lexicon.jpaworkshop.data.dao;

import se.lexicon.jpaworkshop.entity.Book;

import java.util.Collection;

public interface BookDAO {
    Book findById(int id);
    Collection<Book> findAll();
    Book create(Book bookCreate);
    Book update(Book bookUpdate);
    void delete(int toBeDeleted);

}
