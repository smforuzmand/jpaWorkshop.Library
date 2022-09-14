package data;

import entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
public class AppUserDAOsRepository implements AppUserDAO {


    @PersistenceContext
    EntityManager entityManager;


    @Transactional(readOnly = true)
    @Override
    public AppUser findById(int id) {

        if (id <= 0) throw new RuntimeException("Invalid");
        AppUser appUser = entityManager.find(AppUser.class, id);
        return appUser;

    }

    @Transactional(readOnly = true)
    @Override
    public Collection<AppUser> findAll() {

        return entityManager.createQuery("SELECT a FROM AppUser a", AppUser.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public AppUser create(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("appUser left null");
        entityManager.persist(appUser);
        return appUser;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int id) {
        AppUserDAO appUser = new AppUserDAOsRepository();
        entityManager.remove(appUser.findById(id));

    }
}
