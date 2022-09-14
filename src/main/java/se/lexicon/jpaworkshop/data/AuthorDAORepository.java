package se.lexicon.jpaworkshop.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaworkshop.entity.Author;

import java.util.Collection;


@Repository
public class AuthorDAORepository implements AuthorDAO{


    @Transactional(readOnly = true)
    @Override
    public AuthorDAO findById(int authorId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Author> findAll() {
        return null;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Author create(Author author) {
        return null;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Author update(Author author) {
        return null;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int authorId) {

    }
}
