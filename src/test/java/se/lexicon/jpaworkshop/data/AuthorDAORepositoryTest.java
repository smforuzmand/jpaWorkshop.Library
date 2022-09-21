package se.lexicon.jpaworkshop.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaworkshop.data.dao.AuthorDAO;
import se.lexicon.jpaworkshop.data.dao.AuthorDAORepository;
import se.lexicon.jpaworkshop.entity.Author;
import se.lexicon.jpaworkshop.entity.Book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureTestEntityManager
@DirtiesContext
@Transactional
class AuthorDAORepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private AuthorDAORepository authorDAORepository;

    private Author testAuthor;


public List<Author> authors (){
Set<Book> books = new HashSet<>();
    books.add(new Book("123IR", "Sapiens", 15));
    return Arrays.asList(
            new Author("Noah", "Al-Harari", books) {
            }
    );

}

    @Test
    void findById() {

        Author authorTestingFound = authorDAORepository.findById(authors().get(0).getAuthorId());
        assertNotNull(authorTestingFound);



    }








    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}