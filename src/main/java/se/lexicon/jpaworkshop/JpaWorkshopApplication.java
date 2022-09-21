package se.lexicon.jpaworkshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpaworkshop.data.dao.*;
import se.lexicon.jpaworkshop.entity.*;


import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaWorkshopApplication.class, args);

    }


    @Profile("Dev")
    @Component
    @Transactional
    class MyCommandLineRunner implements CommandLineRunner {

        private DetailsDAO detailsDAO;
        private AppUserDAO appUserDAO;
        private EntityManager entityManager;
        private BookDAO bookDAO;
        private BookLoanDAO bookLoanDAO;

        private AuthorDAO authorDAO;

        @Autowired
        public MyCommandLineRunner(DetailsDAO detailsDAO, AppUserDAO appUserDAO, AuthorDAO authorDAO
                , EntityManager entityManager, BookDAO bookDAO, BookLoanDAO bookLoanDAO) {
            this.detailsDAO = detailsDAO;
            this.appUserDAO = appUserDAO;
            this.entityManager = entityManager;
            this.bookDAO = bookDAO;
            this.bookLoanDAO = bookLoanDAO;
            this.authorDAO = authorDAO;
        }


        @Override
        public void run(String... args) {
            System.out.println("This is our command line runner message");
            System.out.println(" --------------------This is a test of the JPA application-----------------------------");

            Author author1 = new Author("author1Fn", "author1ln");

            Set<Author> authors = new HashSet<>();
            authors.add(author1);

            Book book1 = new Book("123isbn", "book1Title", 15, authors);
            author1 = authorDAO.create(author1);
            Details details1 = new Details("details1@email.com", "salomon", LocalDate.parse("1992-01-01"));

            AppUser user1 = new AppUser("User1", "1234asd", LocalDate.parse("2022-01-18"), details1);


            author1 = authorDAO.create(author1);


            book1.addAuthor(author1);
            author1.addBook(book1);
            entityManager.persist(author1);

            book1 = bookDAO.create(book1);

            book1.setAuthors(new HashSet<>());
            BookLoan bookLoan1 = new BookLoan(LocalDate.now(), LocalDate.now().plusDays(15), false, user1, book1);
            bookLoan1 = bookLoanDAO.create(bookLoan1);
            entityManager.persist(bookLoan1);


            details1 = detailsDAO.create(details1);
            entityManager.persist(details1);

            user1 = appUserDAO.create(user1);
            entityManager.persist(user1);



            entityManager.flush();





        }
    }
}
