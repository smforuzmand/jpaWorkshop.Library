package se.lexicon.jpaworkshop;

import se.lexicon.jpaworkshop.data.AppUserDAO;
import se.lexicon.jpaworkshop.data.BookDAO;
import se.lexicon.jpaworkshop.data.BookLoanDAO;
import se.lexicon.jpaworkshop.data.DetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaWorkshopApplication.class, args);
    }

}

@Component
@Transactional
class MyCommandLineRunner implements CommandLineRunner {

    private DetailsDAO detailsDAO;
    private AppUserDAO appUserDAO;
    private EntityManager entityManager;
    private BookDAO bookDAO;
    private BookLoanDAO bookLoanDAO;


    @Autowired
    public MyCommandLineRunner(DetailsDAO detailsDAO, AppUserDAO appUserDAO,
                               EntityManager entityManager, BookDAO bookDAO, BookLoanDAO bookLoanDAO) {
        this.detailsDAO = detailsDAO;
        this.appUserDAO = appUserDAO;
        this.entityManager = entityManager;
        this.bookDAO = bookDAO;
        this.bookLoanDAO = bookLoanDAO;
    }

    @Override
    public void run(String... args) {
        System.out.println("This is our command line runner message");


    }
}