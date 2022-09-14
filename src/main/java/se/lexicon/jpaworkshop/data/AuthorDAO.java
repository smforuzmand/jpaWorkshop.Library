package se.lexicon.jpaworkshop.data;

import se.lexicon.jpaworkshop.entity.Author;

import java.util.Collection;

public interface AuthorDAO {

    AuthorDAO findById(int authorId);

    Collection<Author> findAll();

    Author create(Author author);

    Author update(Author author);

    public void delete(int authorId);






}
