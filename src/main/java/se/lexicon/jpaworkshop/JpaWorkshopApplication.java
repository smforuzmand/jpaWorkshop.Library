package se.lexicon.jpaworkshop;

import data.AppUserDAO;
import data.DetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaWorkshopApplication.class, args);
    }

}

@Component
@ComponentScan("data")
class MyCommandLineRunner implements CommandLineRunner {

    private final DetailsDAO detailsDAO;
    private final AppUserDAO appUserDAO;
    private final EntityManager entityManager;


    @Autowired
    public MyCommandLineRunner(DetailsDAO detailsDAO, AppUserDAO appUserDAO, EntityManager entityManager) {
        this.detailsDAO = detailsDAO;
        this.appUserDAO = appUserDAO;
        this.entityManager = entityManager;
    }

    @Override
    public void run(String... args) {
        System.out.println( "This is our command line runner message");





    }
}