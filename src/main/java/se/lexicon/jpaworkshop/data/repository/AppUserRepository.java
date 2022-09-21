package se.lexicon.jpaworkshop.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.jpaworkshop.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {


    @Query("SELECT a FROM AppUser a WHERE a.userName = :userName")
    Optional<AppUser> findAppUsersByUserName(@Param("userName") String userName);


    List<AppUser> findAppUsersByUserDetails_BirthDateBefore(LocalDate dateBefore);

    List<AppUser> findAppUsersByUserDetails_BirthDateAfter(LocalDate dateAfter);

    Optional<AppUser> findAppUsersByUserDetailsEmail(String email);




}
